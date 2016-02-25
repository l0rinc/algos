package pap.lorinc.algos.sort

import static java.util.Collections.swap

final class Selection {
    private Selection() {}

    static <T extends Comparable<?>> Collection<T> sort(Collection<T> originalElems) {
        def elems = originalElems.toList()
        sortInPlace(elems)
        elems
    }

    static <T extends Comparable<?>> void sortInPlace(List<T> elems) {
        if (elems.size() <= 1) return

        elems.indices.each { int i ->
            int minIndex = i
            (i..<elems.size()).each { int j ->
                (elems[j] < elems[minIndex]) && (minIndex = j)
            }
            (i != minIndex) && swap(elems, i, minIndex)
        }
    }
}
