package pap.lorinc.algos.ctci._05

/** Swap the even and odd bits of an integer */
class _05_07_PairwiseSwap {
    /** Complexity: O(1) */
    private static ODD_MASK = 0b01010101_01010101_01010101_01010101
    static swapOddEvenBits(int num) {
        ((num >> 1) & ODD_MASK) | ((num & ODD_MASK) << 1)
    }
}
