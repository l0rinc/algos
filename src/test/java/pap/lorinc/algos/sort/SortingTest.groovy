package pap.lorinc.algos.sort

import spock.genesis.Gen
import spock.lang.Specification

class SortingTest extends Specification {
    static final int ITERATIONS = 3
    static final int SIZE = 20000

    /*@formatter:off*/
    def 'Insersion sort?'() {
        expect: Insertion.sort(elems) == referenceSortedElems
        where:  size << Gen.integer(0, SIZE) * ITERATIONS
                elems = (Gen.integer * size).collect()
                referenceSortedElems = elems.sort(false).asImmutable()
    }

    def 'Selection sort?'() {
        expect: Selection.sort(elems) == referenceSortedElems
        where:  size << Gen.integer(0, SIZE) * ITERATIONS
                elems = (Gen.integer * size).collect()
                referenceSortedElems = elems.sort(false).asImmutable()
    }

    def 'Merge sort?'() {
        expect: Merge.sort(elems) == referenceSortedElems
        where:  size << Gen.integer(0, SIZE) * ITERATIONS
                elems = (Gen.integer * size).collect()
                referenceSortedElems = elems.sort(false).asImmutable()
    }
    /*@formatter:on*/
}
