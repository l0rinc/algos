package pap.lorinc.algos.ctci._05

import spock.lang.*

import static pap.lorinc.algos.ctci._05._05_05_PowerOfTwo.isPowerOf2

@Unroll class _05_05_PowerOfTwoTest extends Specification {
    /*@formatter:off*/
    def '#sources isPowerOf2 == #verdict?'() {
        expect: sources.each { assert isPowerOf2(it) == verdict } 
        where:  sources   || verdict
                (0..30).collect { 1 << it } || true 
                [0,-1,-2,-3,-4,-5,-6,-7,-8] || false 
    }
    /*@formatter:on*/
}
