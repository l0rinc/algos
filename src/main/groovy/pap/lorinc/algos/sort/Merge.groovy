package pap.lorinc.algos.sort

import org.codehaus.groovy.runtime.DefaultGroovyMethods

import static pap.lorinc.algos.sort.Merger.mergeMin

@SuppressWarnings("GrMethodMayBeStatic")
final class Merge<T extends Comparable<?>> {
    private Merge() {}

    static <T extends Comparable<?>> Collection<T> sort(Collection<T> originalElems) {
        def sort = new Merge<T>()
        sort.mergeSort(originalElems.toList())
    }

    def mergeSort(List<T> elems) {
        (elems.size() <= 1) ? elems
                            : mergeMin(mergeSort(left(elems)),
                                       mergeSort(right(elems)))
    }

    def left(List<T> elems) { elems.subList(0, mid(elems)) }
    def right(List<T> elems) { elems.subList(mid(elems), elems.size()) }

    def mid(List<T> elems) { elems.size() >> 1 }
}

final class Merger {
    final List<List> lists
    final List<Integer> indices
    final Closure minMax

    private Merger(Closure minMax, List... lists) {
        this.minMax = minMax
        this.lists = lists.toList()
        this.indices = [0] * lists.size()
    }

    static mergeMin(List... lists) { merge(DefaultGroovyMethods.&min, lists) }
    static mergeMax(List... lists) { merge(DefaultGroovyMethods.&max, lists) }

    private static merge(Closure minMax, List... lists) { new Merger(minMax, lists).doMerge() }

    def doMerge() {
        def results = []
        for (def value = next(); value != null; value = next())
            results << value
        results
    }

    def next() {
        def columns = lists.indices
                           .collect { i -> [i, get(i)] }
                           .findAll { it[1] != null }
        if (columns.empty) return null

        def (minIndex, minValue) = minMax(columns, { it[1] })
        indices[minIndex]++
        minValue
    }

    def get(int i) {
        (i < lists.size()) ? lists[i][indices[i]]
                           : null
    }
}
