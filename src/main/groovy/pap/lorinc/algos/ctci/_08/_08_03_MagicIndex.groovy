package pap.lorinc.algos.ctci._08

/** Find the index that equals the value in an ascending (unique?) list */
class _08_03_MagicIndex {
    /** Complexity: O(log elements.length) */
    static magicIndex(List<Integer> elements, int startInclusive = 0, int endExclusive = elements.size()) {
        if (startInclusive > endExclusive) return null

        int middleIndex = startInclusive + ((endExclusive - startInclusive) / 2)
        def middleElement = elements[middleIndex]

        if (middleIndex == middleElement)
            return middleIndex
        else {
            def index = magicIndex(elements, startInclusive, [middleIndex - 1, middleElement].min())
            if (index == null)
                index = magicIndex(elements, [middleIndex + 1, middleElement].max(), endExclusive)
            return index
        }
    }
}