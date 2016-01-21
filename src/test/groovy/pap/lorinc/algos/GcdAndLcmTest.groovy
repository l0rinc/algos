package pap.lorinc.algos

import spock.genesis.Gen
import spock.lang.Specification

import static pap.lorinc.algos.GcdAndLcm.*
import static pap.lorinc.algos.helpers.Numbers.canDivide

class GcdAndLcmTest extends Specification {
    private static int ITERATIONS = 1000
    private static IntRange RANGE = 0..Integer.MAX_VALUE

    /*@formatter:off*/
    def 'Greatest common divisor - by example'(long first, long second, long result) {
        when:   def gcd = gcd(first, second);
        then:   gcd == result
        where:  first | second || result
                2     | 4      || 2
                9     | 28     || 1
                42    | 56     || 14
                48    | 180    || 12
                54    | 24     || 6
    }

    def 'Greatest common divisor - property based'(long first, long second) {
        when:   def gcd = gcd(first, second);

        then:   canDivide(first, gcd);
        and:    canDivide(second, gcd);

        where:  first << Gen.integer(RANGE) * ITERATIONS
                second << Gen.integer(RANGE) * ITERATIONS
    }

    def 'Least common multiple by example'(long first, long second, long result) {
        when:   def lcm = lcm(first, second);
        then:   lcm == result
        where:  first | second || result
                2     | 4      || 4
                3     | 4      || 12
                24    | 300    || 600
                48    | 180    || 720
                65    | 330    || 4290
    }

    def 'Least common multiple by example - property based'(long first, long second) {
        when:   def lcm = lcm(first, second);

        then:   canDivide(lcm, first);
                canDivide(lcm, second);
                lcm <= first * second

        where:  first << Gen.integer(RANGE) * ITERATIONS
                second << Gen.integer(RANGE) * ITERATIONS
    }
    /*@formatter:on*/
}
