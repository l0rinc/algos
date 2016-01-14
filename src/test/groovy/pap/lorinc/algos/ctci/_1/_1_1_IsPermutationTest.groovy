package pap.lorinc.algos.ctci._1

import spock.lang.Specification

import static pap.lorinc.algos.ctci._1._1_2_IsPermutation.isPermutation

class _1_1_IsPermutationTest extends Specification {
    /*@formatter:off*/
    def 'IsPermutation?'() {
        expect: isPermutation(original.collect(), candidate.collect()) == result
        where:  original  | candidate || result
                '1234'    | '3142'    || true
                '1234567' | '5371624' || true
                '1234'    | '3141'    || false
                '1234'    | '12345'   || false
    }
    /*@formatter:on*/
}
