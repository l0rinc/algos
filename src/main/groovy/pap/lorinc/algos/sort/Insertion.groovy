package pap.lorinc.algos.sort

import static java.util.Collections.swap

final class Insertion {
    private Insertion() {}

    static <T extends Comparable<?>> Collection<T> sort(Collection<T> originalElems) {
        def elems = originalElems.toList()
        sortInPlace(elems)
        elems
    }

    static <T extends Comparable<?>> void sortInPlace(List<T> elems) {
        if (elems.size() <= 1) return

        elems.indices.each { int i ->
            (i..<0).find { int j ->
                !((elems[j] < elems[j - 1])
                && !swap(elems, j, j - 1))
            }
        }
    }
}
