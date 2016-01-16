package pap.lorinc.algos.ctci._1

import static java.util.Collections.binarySearch

/** Determine if a string has unique characters */
class _1_1_IsUnique {
    static isUnique(List values) {
        def squared = isUnique_Squared(values)
        def linearithmic = isUnique_Linearithmic(values)
        def linear = isUnique_Linear(values)

        assert [squared, linearithmic].every { it == linear }

        linear
    }

    /** O(values.size()**2), no additional space */
    static isUnique_Squared(List values) {
        for (i in values.indices)
            if (values.findLastIndexOf(i + 1) { it == values[i] } >= 0)
                return false
        true
    }

    /** O(n log n), where n = values.size(), no additional space. Could be O(n) also, with O(n) space */
    static isUnique_Linearithmic(List values) {
        values = values.clone()
        values.sort()
        for (i in values.indices)
            if (binarySearch(values, values[i]) != i)
                return false
        true
    }

    /** O(values.size()), but needs same amount of space */
    static isUnique_Linear(List values) {
        Set seen = []
        values.every { seen.add(it) }
    }
}