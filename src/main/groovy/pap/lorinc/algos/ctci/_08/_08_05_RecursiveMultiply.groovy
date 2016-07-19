package pap.lorinc.algos.ctci._08

import static pap.lorinc.algos.helpers.Numbers.isOdd

/** */
class _08_05_RecursiveMultiply {
    /** Complexity: O(log multiplier) */
    static multiply(int multiplier, int multiplicand) {
        if (multiplier == 1)
            multiplicand
        else {
            def oddFactor = isOdd(multiplier) ? multiplicand : 0
            oddFactor + multiply(multiplier >> 1, multiplicand << 1)
        }
    }
}