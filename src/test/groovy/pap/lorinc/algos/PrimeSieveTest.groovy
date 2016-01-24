package pap.lorinc.algos

import pap.lorinc.algos.helpers.Numbers
import spock.genesis.Gen
import spock.lang.*

import static pap.lorinc.algos.PrimeSieve.getPrimesUntil

@Unroll class PrimeSieveTest extends Specification {
    private static int ITERATIONS = 5
    private static int RANGE_END = 200000

    /*@formatter:off*/
    def 'The first #primes.size() primes are calculated correctly - by example'() {
        when:   def calculated = getPrimesUntil primes.last()
        then:   calculated == primes
        where:  primes                                                                                                                                           | _
                [2]                                                                                                                                              | _
                [2,3,5,7,11]                                                                                                                                     | _
                [2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97,101,103,107,109,113,127,131,137,139,149,151,157,163,167,173,179,181,191] | _
    }

    def 'The first #primes.size() primes are calculated correctly'() {
        when:   def calculated = getPrimesUntil primes.last()
        then:   calculated == primes
        where:  primes << primeListGenerator()
    }
    /*@formatter:on*/

    private static Collection<Collection<Integer>> primeListGenerator() {
        def sizes = (Gen.integer(0, RANGE_END) * ITERATIONS).collect()
        sizes.collect { size ->
            (2..size).findAll { Numbers.isProbablePrime(it as long, 200 as short) }
        }
    }
}
