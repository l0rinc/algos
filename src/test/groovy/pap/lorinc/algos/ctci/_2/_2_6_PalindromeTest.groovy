package pap.lorinc.algos.ctci._2

import pap.lorinc.algos.ctci._2.utils.Node
import spock.lang.*

import static pap.lorinc.algos.ctci._2._2_6_Palindrome.isPalindrome_withStack

@Unroll class _2_6_PalindromeTest extends Specification {
    /*@formatter:off*/
    def 'palindrome?'() {
        when:   def head = Node.from(values.toList())
        then:   isPalindrome_withStack(head) == verdict
        where:  values      || verdict
                [1]         || true
                [1,1]       || true
                [1,2,1]     || true
                [1,2,2,1]   || true
                [1,2,3,2,1] || true
                'racecar'   || true

                [2,1]       || false
    }
    /*@formatter:on*/
}
