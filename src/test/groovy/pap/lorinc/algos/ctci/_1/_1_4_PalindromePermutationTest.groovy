package pap.lorinc.algos.ctci._1

import spock.lang.*

import static pap.lorinc.algos.ctci._1._1_4_PalindromePermutation.canBePalindrome

@Unroll class _1_4_PalindromePermutationTest extends Specification {
    /*@formatter:off*/
    def 'PalindromePermutation?'() {
        expect: canBePalindrome(shuffle(string)) == verdict
        where:  string                           || verdict
                'Rats live on no evil star'      || true
                'Eva, can I stab bats in a cave' || true
                'Was it a car or a cat I saw?'   || true
                "Dammit, I'm mad"                || true

                'racecars'                       || false
    }
    /*@formatter:on*/

    static shuffle(String string) {
        def collect = string.toList()
        Collections.shuffle(collect)
        collect.join()
    }
}
