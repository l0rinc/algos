package pap.lorinc.algos.ctci._08

/** Calculate the permutations of a list of unique elements */
class _08_07_PermutationsWithoutDups {
    /** Complexity: O(elements.size!) */
    static <T> List<List<T>> permutations(List<T> elements, List<T> result = [], List<List<T>> results = []) {
        if (result.size() == elements.size()) results << result
        else (elements - result).each { permutations(elements, result + it, results) }
        results
    }
}