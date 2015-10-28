package pap.lorinc.algos.sort

import spock.genesis.Gen
import spock.lang.Specification

class SortingTest extends Specification {
    static final int ITERATIONS = 10
    static final int SIZE = 1000

    /*@formatter:off*/
    def 'Different sorting algorithms give the same results'() {
        expect: Insertion.sort(elems) == referenceSortedElems
                Selection.sort(elems) == referenceSortedElems

        where:  size << Gen.integer(0, SIZE) * ITERATIONS
                elems = (Gen.integer * size).collect()
                referenceSortedElems = elems.sort(false).asImmutable()
    }
    /*@formatter:on*/
}
