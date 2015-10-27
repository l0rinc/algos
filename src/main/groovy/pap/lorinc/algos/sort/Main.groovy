package pap.lorinc.algos.sort

import groovy.transform.CompileStatic

@CompileStatic class Main {
    static void main(String... args) {
        List<Integer> elems = getRandomList(1000)
        def referenceSortedElems = elems.sort(false).asImmutable()

        assert Insertion.sort(elems) == referenceSortedElems
        assert Selection.sort(elems) == referenceSortedElems
        assert Merge.sort(elems) == referenceSortedElems
    }

    private static List<Integer> getRandomList(int size) {
        def rand = new Random()
        (0..<size).collect { rand.nextInt() }.asImmutable()
    }
}
