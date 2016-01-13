package pap.lorinc.algos.sandbox

import pap.lorinc.algos.utils.StopWatch

import static pap.lorinc.algos.utils.RandomGenerator.generateRandomString

/* Generate all permutations of the elements of a collection */
class Permutations {
    static void main(String... args) {
        def values = generateRandomString(1..10, 'a'..'z').collect()
        def (result, elapsed) = StopWatch.run {
            def count = 0
            permute(values) { count++ }
            count
        }
        println "$result \t\t\t ($elapsed)"
    }

    // TODO would it be faster if we cloned the possibilities instead of checking previously chosen values?
    static permute(Collection<Object> values, Closure closure, LinkedHashMap<Integer, Object> results = [:]) {
        values.eachWithIndex { Object v, Integer i ->
            if (!results.put(i, v)) {
                if (results.size() == values.size())
                    closure(results.values())
                else permute(values, closure, results)

                results.remove(i)
            }
        }
    }
}