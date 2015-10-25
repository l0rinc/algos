package pap.lorinc.algos.helpers

import spock.genesis.Gen
import spock.lang.Specification
import spock.lang.Unroll

import static pap.lorinc.algos.helpers.Numbers.pow

class NumbersTest extends Specification {
    private static int ITERATIONS = 1000

    /*@formatter:off*/
    @Unroll def "#number^#exponent = #result"(long number, byte exponent, long result) {
        when:   def power = pow(number, exponent)
        then:   power == result
        where:  number << Gen.integer(1, Short.MAX_VALUE) * ITERATIONS
                exponent = Gen.integer(0, maxExponent(number)).next()
                result = number ** exponent
    }
    /*@formatter:on*/

    static int maxExponent(long number) { Math.log(Long.MAX_VALUE) / Math.log(number) }
}
