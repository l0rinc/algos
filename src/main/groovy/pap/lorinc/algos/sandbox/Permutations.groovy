package pap.lorinc.algos.sandbox

import groovy.transform.CompileStatic
import pap.lorinc.algos.utils.StopWatch

/*
 * Simulate a Secret Santa gift game with n people.
 * What is the probability that nobody picks its own name?
**/
@CompileStatic
class Permutations {
    static List simulateSecretSanta(int n) {
        def (IntRange range, int all, int ok) = [0..<n, 0, 0]
        new PermutationGenerator(range).each { List p ->
            all++
            if (range.every { i -> i != p[i] })
                ok++
        }
        [ok, all]
    }

    static void main(String... args) {
        (1..13).each { n ->
            def run = StopWatch.run {
                List<Number> values = simulateSecretSanta(n) as List<Number>
                def ok = values[0]
                def all = values[1]
                "$n: 1-$ok/$all = ${1 - ok / all}"
            }
            def result = run[0]
            def elapsed = run[1]
            println "$result \t\t\t ($elapsed)"
        }
    }
}