package pap.lorinc.algos.ctci._0

import spock.genesis.Gen
import spock.lang.Specification

import static pap.lorinc.algos.ctci._0.SortedCollectionIntersection.intersection

class SortedCollectionIntersectionTest extends Specification {
    /*@formatter:off*/
    def 'Sorted collection intersection?'() {
        expect: intersection(first, second) == first.intersect(second)
        where:  first      | second
                [1,2,3]    | [4]
                [1,2,3]    | [2,4]
                [1,2,3]    | [1,2,3]
                [10,20,30] | [20,21,22]
    }

    def 'Random collections intersect?'() {
        expect: intersection(first, second) == first.intersect(second)
        where:  first  = (Gen.integer * Gen.integer(0, 1000000).next()).collect().sort()
                second = (Gen.integer * Gen.integer(0, 1000000).next()).collect().sort()
    }
    /*@formatter:on*/
}