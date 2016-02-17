package pap.lorinc.algos.ctci._01

import spock.lang.*

import static _01_06_RunLengthEncoding.compress

@Unroll class _01_06_RunLengthEncodingTest extends Specification {
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
