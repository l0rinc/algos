package pap.lorinc.algos.ctci._1

import spock.lang.Specification

import static pap.lorinc.algos.ctci._1._1_6_RunLengthEncoding.compress

class _1_6_RunLengthEncodingTest extends Specification {
    /*@formatter:off*/
    def 'compress?'() {
        expect: compress(original) == compressed
        where:  original      || compressed
                ''            || ''
                'a'           || 'a'
                'aa'          || 'aa'
                'aaa'         || 'a3'
                'aaaa'        || 'a4'
                'aabcccccaaa' || 'a2b1c5a3'
    }
    /*@formatter:on*/
}
