package pap.lorinc.algos.ctci._00

import pap.lorinc.algos.utils.StopWatch

import static pap.lorinc.algos.utils.RandomGenerator.generateRandomString

/** Generate all permutations of the elements of a collection */
class Permutations {
    static void main(String... args) {
        def values = generateRandomString(10, 'a'..'z').collect()
        def (result, elapsed) = StopWatch.run {
            def count = 0
            permute(values) { count++ }
            count
        }
        println "$result \t\t\t ($elapsed)"
    }

    /** Complexity: O(values.size()!) */
    static permute(Collection<Object> values, Closure closure, List<Object> results = []) {
        if (values.empty) closure(results)
        else values.eachWithIndex { v, i ->
            permute(cloneWithoutElement(values, i), closure, results + v)
        }
    }

    static cloneWithoutElement(Collection<Object> values, int i) {
        values = values.clone()
        values.remove(i)
        values
    }
}