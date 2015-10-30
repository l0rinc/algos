package pap.lorinc.algos.sort

import groovy.transform.CompileStatic

import static java.util.Collections.swap

@CompileStatic final class Selection {
    private Selection() {}

    static <T extends Comparable<?>> Collection<T> sort(Collection<T> originalElems) {
        def elems = originalElems.toList()
        elems.indices.each { int i ->
            int minIndex = i
            (i..<elems.size()).each { int j ->
                (elems[j] < elems[minIndex]) && (minIndex = j)
            }
            (i != minIndex) && swap(elems, i, minIndex)
        }
        elems
    }
}
