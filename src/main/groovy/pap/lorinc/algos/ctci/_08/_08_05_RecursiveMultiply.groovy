package pap.lorinc.algos.ctci._08

import groovy.transform.Memoized

import static pap.lorinc.algos.helpers.Numbers.isOdd

/** */
class _08_05_RecursiveMultiply {
    /** Complexity: O(log min(multiplier, multiplicand)) */
    static multiply(int multiplier, int multiplicand) {
        def (int small, int big) = [multiplier, multiplicand].sort()
        if (small == 1)
            big
        else {
            def oddFactor = isOdd(small) ? big : 0
            oddFactor + multiply(small >> 1, big << 1)
        }
    }
}