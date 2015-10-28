package pap.lorinc.algos.sort

import groovy.transform.Memoized

final class Merge<T extends Comparable<?>> {
    private Merge() {}

    static <T extends Comparable<?>> Collection<T> sort(Collection<T> originalElems) {
        def sort = new Merge<T>()
        sort.mergeSort(originalElems.toList())
    }

    def mergeSort(List<T> elems) {
        (elems.size() <= 1) ? elems
                            : merge(mergeSort(left(elems)),
                                    mergeSort(right(elems)))
    }

    def merge(List<T> leftElems, List<T> rightElems) {
        def results = []

        int j = 0
        for (def left : leftElems) {
            for (; j < rightElems.size() && rightElems[j] < left; j++)
                results << rightElems[j]
            results << left
        }

        results + rightElems.subList(j, rightElems.size())
    }

    def left(List<T> elems) { elems.subList(0, mid(elems)) }
    def right(List<T> elems) { elems.subList(mid(elems), elems.size()) }

    @Memoized int mid(List elems) { elems.size() >> 1 }
}