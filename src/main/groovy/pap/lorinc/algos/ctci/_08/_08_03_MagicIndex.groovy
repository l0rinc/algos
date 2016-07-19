package pap.lorinc.algos.ctci._08

/** Find the index that equals the value in a sorted list */
class _08_03_MagicIndex {
    /** Complexity: O(log elements.length) */
    static magicIndex(List<Integer> elements, int startInclusive = 0, int endExclusive = elements.size()) {
        if (startInclusive >= endExclusive) return null

        int middleIndex = startInclusive + ((endExclusive - startInclusive) / 2)
        def middleElement = elements[middleIndex]
        if      (middleIndex < middleElement) return magicIndex(elements, startInclusive, middleIndex)
        else if (middleIndex > middleElement) return magicIndex(elements, middleIndex + 1, endExclusive)
        else                                  return middleIndex
    }
}