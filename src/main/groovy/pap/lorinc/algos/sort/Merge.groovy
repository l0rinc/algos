package pap.lorinc.algos.sort

import groovy.transform.CompileStatic
import groovy.transform.Memoized

@CompileStatic class Merge {
    static <T extends Comparable<T>> Collection<T> sort(Collection<T> originalElems) {
        mergeSort originalElems.toList()
    }

    private static <T extends Comparable<T>> List<T> mergeSort(List<T> elems) {
        (elems.size() < 2) ? elems
                           : merge(mergeSort(left(elems)),
                                   mergeSort(right(elems)))
    }

    private static <T extends Comparable<T>> List<T> merge(List<T> left, List<T> right) {
        def results = []
        def rightIter = 0
        left.each { l ->
            for (T r = right[rightIter] as T; r < l; rightIter++)
                results += r
            results += l
        }
        results.addAll right.subList(rightIter, right.size())
        results
    }

    private static <T extends Comparable<T>> List<T> left(List<T> elems) {
        elems.subList 0, mid(elems)
    }
    private static <T extends Comparable<T>> List<T> right(List<T> elems) {
        elems.subList mid(elems) + 1, elems.size()
    }

    private static @Memoized int mid(List elems) {
        elems.size() / 2 as int
    }
}