package pap.lorinc.algos.ctci._08

import groovy.transform.Memoized

/** In how many ways can a child go up the stairs, if she can hop 1, 2 or 3 steps at a time? */
class _08_01_TripleStep {
    private static final STEPS = 1..3

    /** Complexity: O(remainingStairs * STEPS.size()) */
    @Memoized /*@TailRecursive*/ static possibilities(int remainingStairs) {
        STEPS.sum { int stepSize ->
            switch (remainingStairs <=> stepSize) {
                case -1: return 0
                case 0: return 1
                case +1: return possibilities(remainingStairs - stepSize)
            }
        }
    }

    /* Tn = Tn-1 + Tn-2 + Tn-3, starting with 1,1,2 */
    @Memoized /*@TailRecursive*/ static tribonacci(int remainingStairs) {
        [1, 1, 2][remainingStairs] ?: STEPS.sum { tribonacci(remainingStairs - it) }
    }
}