package pap.lorinc.algos;

import org.jetbrains.annotations.Nullable;

import java.util.Iterator;

import static java.lang.Math.*;
import static pap.lorinc.algos.TriangularValidator.validate;

public class TriangularCollection<T> implements Iterable<T> {
    private final Object[] sparseMatrix;

    public TriangularCollection(T[][] fullMatrix) {
        validate(fullMatrix);

        sparseMatrix = new Object[toSparseSize(fullMatrix.length)];
        fillSparseMatrix(fullMatrix);
    }

    private static int toSparseSize(int fullSize) {
        return ((fullSize - 1) * fullSize) / 2;
    }

    private void fillSparseMatrix(T[][] fullMatrix) {
        for (int i = 0, currentIndex = 0; i < fullMatrix.length; i++)
            for (int j = 0; j < i; j++)
                sparseMatrix[currentIndex++] = fullMatrix[i][j];
    }

    /**
     * <pre>{@code
     * fs = full matrix size = √(full matrix element count)
     * ss = sparse matrix element count
     *
     * (fs - 1) * fs / 2 = ss
     * fs ^ 2 - fs - 2 * ss = 0
     * fs = (1 + sqrt(1 + 8 * ss)) / 2
     * }</pre>
     */
    public int size() {
        return (1 + (int) sqrt(1 + (sparseMatrix.length * 8))) / 2;
    }

    @SuppressWarnings("unchecked")
    public @Nullable T get(int i, int j) {
        return (i == j) ? null
                        : (T) sparseMatrix[toSparseSize(max(i, j)) + min(i, j)];
    }

    @Override public Iterator<T> iterator() {
        return new TriangularIterator<>(this);
    }
}

class TriangularIterator<T> implements Iterator<T> {
    private final TriangularCollection<T> triangularCollection;
    private final int size;

    private int index = 0;

    protected TriangularIterator(TriangularCollection<T> triangularCollection) {
        this.triangularCollection = triangularCollection;
        size = triangularCollection.size();
    }

    @Override public boolean hasNext() {
        return index < (size * size);
    }

    @Nullable @Override public T next() {
        int i = index / size, j = index % size;
        index++;
        return (T) triangularCollection.get(i, j);
    }
}

class TriangularValidator {
    protected static <T> void validate(T[][] fullMatrix) {
        int size = fullMatrix.length;
        for (T[] row : fullMatrix)
            if (size != row.length)
                throw new IllegalArgumentException();

        for (int i = 0; i < size; i++)
            if (fullMatrix[i][i] != null)
                throw new IllegalArgumentException();

        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                //noinspection ObjectEquality
                if (fullMatrix[i][j] != fullMatrix[j][i])
                    throw new IllegalArgumentException();
    }
}