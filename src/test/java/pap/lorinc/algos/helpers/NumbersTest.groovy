package pap.lorinc.algos.helpers

import spock.genesis.Gen
import spock.lang.Specification

class NumbersTest extends Specification {
    private static int ITERATIONS = 1000

    /*@formatter:off*/
    def "#number^#exponent = #result mod #modulo"(int number, int exponent, int modulo, long result) {
        when:   def power = Numbers.pow(number, exponent, modulo)
        then:   power == result

        where:  number << Gen.integer(1, Short.MAX_VALUE) * ITERATIONS
                exponent = Gen.integer(0, number).next()
                modulo = Gen.integer(1, number + 1).next()
                result = (number ** exponent) % modulo
    }

    def 'canDivide?'(long dividend, long divisor, boolean result) {
        when:   def canDivide = Numbers.canDivide(dividend, divisor)
        then:   canDivide == result

        where:  dividend    | divisor || result
                128         | 2       || true
                10          | 10      || true
                10          | 1       || true

                7           | 10      || false
                123_456_789 | 314     || false
    }

    def 'isEven?'() {
        when:   def isEven = Numbers.isEven(number)
        then:   isEven == canDivide

        where:  number << Gen.long * ITERATIONS
                canDivide = Numbers.canDivide(number, 2L)
    }

    def 'maxExponent?'(long number, int maxExponent) {
        when:   def exponent = 0
                for (def result = Long.MAX_VALUE; result > number; result /= number)
                    exponent++
        then:   exponent == maxExponent

        where:  number << Gen.integer(0, Integer.MAX_VALUE) * ITERATIONS
                maxExponent = Numbers.maxExponent(number)
    }
    /*@formatter:on*/
}
