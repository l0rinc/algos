package pap.lorinc.algos.ctci._1

/** Given a string, check whether palindromes can be formed from it */
class _1_4_PalindromePermutation {
    /** Complexity: O(string.size()), uses same amount of space */
    static canBePalindrome(String string) {
        def normalizedString = string.toLowerCase().replaceAll('\\W', '')
        def groups = normalizedString.collect().groupBy()
        def oddGroups = groups.findAll { k, v -> (v.size() % 2 != 0) }
        oddGroups.size() <= 1
    }
}