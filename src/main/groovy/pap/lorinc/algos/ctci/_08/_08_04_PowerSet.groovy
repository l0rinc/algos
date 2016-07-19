package pap.lorinc.algos.ctci._08

/** Calculate all subsets of a set */
class _08_04_PowerSet {
    /** Complexity: O((elements.size()+1)!) */
    static subsets(Set elements) {
        Set results = []
        for (int i = 1; i <= elements.size(); i++)
            permutations(elements, i) { p ->
                results << p
            }
        results
    }

    static permutations(Set elements, int size, Set remaining = elements, Set results = [], Closure consumer) {
        if (results.size() == size)
            consumer.call(results)
        else {
            remaining.each { permutations(elements, size, remaining - it, results + it, consumer) }
        }
    }
}