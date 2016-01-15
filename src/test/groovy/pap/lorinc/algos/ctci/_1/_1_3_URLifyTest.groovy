package pap.lorinc.algos.ctci._1

import spock.lang.Specification

import static pap.lorinc.algos.ctci._1._1_3_URLify.urlify

class _1_3_URLifyTest extends Specification {
    /*@formatter:off*/
    def 'URLify?'() {
        when:   def expected = string[0..<length].replace(search, replacement)
                def actual = urlify(string, length, search, replacement)
        then:   actual == expected
        where:  string              | length | search | replacement
                'xyx'               | 3      | 'x'    | 'y'
                'xyyx '             | 4      | 'yy'   | 'yyy'
                'Mr John Smith    ' | 13     | ' '    | '%20'
                'aabbccddccbbaa'    | 14     | 'bb'   | '**'
                'abcabcbacbacba'    | 14     | 'ba'   | '**'
    }
    /*@formatter:on*/
}
