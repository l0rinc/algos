package pap.lorinc.algos.ctci._1

/** Determine if two strings are each other's permutation */
class _1_2_IsPermutation {
    static isPermutation(List original, List candidate) {
        def linearithmic = isPermutation_Linearithmic(original, candidate)
        def linear = isPermutation_Linear(original, candidate)

        assert linearithmic == linear

        linear
    }

    /** Complexity: O(n log n), where n = orginal.size(), uses O(n) size */
    static isPermutation_Linearithmic(List original, List candidate) {
        (original.size() == candidate.size() /* avoid sorting the second one, if their sizes don't match */
        && original.sort(false) == candidate.sort(false))
    }

    /** Complexity: O(n), where n = orginal.size(), uses same size */
    static isPermutation_Linear(List original, List candidate) {
        (original.size() == candidate.size()
        && original.groupBy() == candidate.groupBy())
    }
}