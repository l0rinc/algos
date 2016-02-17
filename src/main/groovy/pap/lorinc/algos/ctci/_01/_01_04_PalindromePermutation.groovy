package pap.lorinc.algos.ctci._01

import static java.lang.Character.isLetter
import static pap.lorinc.algos.helpers.Numbers.isEven

/** Given a string, check whether palindromes can be formed from it */
class _01_04_PalindromePermutation {
    static canBePalindrome(String string) {
        def linearLinear = canBePalindrome_Linear_Linear(string)
        def linear = canBePalindrome_Linear(string)

        assert linearLinear == linear
        linear
    }

    /** Complexity: O(string.size()), uses same amount of space */
    static canBePalindrome_Linear_Linear(String string) {
        def normalizedString = string.toLowerCase().replaceAll('\\W', '')
        def groups = normalizedString.toList().groupBy()
        def oddGroups = groups.findAll { k, v -> !isEven(v.size()) }
        oddGroups.size() <= 1
    }

    /** Complexity: O(string.size()), uses constant space */
    static canBePalindrome_Linear(String string) {
        def groups = new BitSet()
        for (int c : string.toLowerCase())
            isLetter(c) && groups.flip(c)
        groups.cardinality() < 2;
    }
}