package pap.lorinc.algos.ctci._08

/** Calculate the permutations of a list of non-unique elements */
class _08_08_PermutationsWithDups {
    /** Complexity: O(elements.size!) */
    static <T> List<Set<T>> permutations(List<T> elements) {
        recurse(elements.countBy { it }, elements.size(), [], [])
    }

    private static <T> List<Set<T>> recurse(Map<T, Integer> frequencies, int size, List<T> result, List<Set<T>> results) {
        if (result.size() == size) results << result
        else frequencies.findAll { e, f -> f > 0 }.each { element, frequency ->
            def newFrequencies = frequencies + [(element): (frequency - 1)]
            def newResult = result + element
            recurse(newFrequencies, size, newResult, results)
        }
        results
    }
}