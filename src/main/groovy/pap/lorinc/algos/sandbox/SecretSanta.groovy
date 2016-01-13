package pap.lorinc.algos.sandbox

import pap.lorinc.algos.utils.StopWatch

/*
 * Simulate a Secret Santa gift game with n people.
 * What is the probability that nobody picks its own name?
**/
class SecretSanta {
    static void main(String... args) {
        (1..13).each { n ->
            def (result, elapsed) = StopWatch.run {
                def (ok, all) = simulateSecretSanta(n)
                "$n: $ok/$all = ${ok / all}"
            }
            println "$result \t\t\t ($elapsed)"
        }
    }

    static List<Number> simulateSecretSanta(int n) {
        def (range, all, ok) = [0..<n, 0, 0]
        new PermutationGenerator(range).each { List p ->
            all++
            if (range.every { i -> i != p[i] })
                ok++
        }
        [ok, all]
    }
}