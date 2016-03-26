package pap.lorinc.algos.sandbox

import groovy.transform.Canonical

/** Given a sequence of dominoes (containing two numbers), find the longest chain where the `right` of a previous equals the `left` of the current one. */
class DominoSequence {
    /** Complexity: O(dominoes.size) with same space usage */
    static longestSequence(List<Domino> dominoes) {
        def lengths = [:].withDefault { 0 }
        dominoes.collect { lengths[it.right] = lengths[it.left] + 1 }
                .max()
    }
}

@Canonical class Domino {
    String left, right
    static of(Object left, Object right) { new Domino(left.toString(), right.toString()) }

    @Override String toString() { "($left,$right)" }
}
