package pap.lorinc.algos.ctci._1

import static pap.lorinc.algos.helpers.Numbers.isEven

/** Given a string, check whether palindromes can be formed from it */
class _1_4_PalindromePermutation {
    /** Complexity: O(string.size()), uses same amount of space */
    static canBePalindrome(String string) {
        def normalizedString = string.toLowerCase().replaceAll('\\W', '')
        def groups = normalizedString.collect().groupBy()
        def oddGroups = groups.findAll { k, v -> !isEven(v.size()) }
        oddGroups.size() <= 1
    }
}