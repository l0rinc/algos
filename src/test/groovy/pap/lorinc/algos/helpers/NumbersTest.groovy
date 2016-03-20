package pap.lorinc.algos.helpers

import spock.genesis.Gen
import spock.genesis.generators.values.LongGenerator
import spock.lang.*

import static pap.lorinc.algos.sandbox.RandomGeneratorTest.hasUniformDistribution

class NumbersTest extends Specification {
    private static int ITERATIONS = 100

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

    def 'isProbablePrime?'() {
        when:   def expected = range.findAll { (it as BigInteger).isProbablePrime(probability) }
                def actual = range.findAll { Numbers.isProbablePrime(it as long, probability) }
        then:   actual == expected

        where:  range = 2..100_000
                probability = 200 as short
    }

    def 'random?'(int start, int end) {
        when:   def chosen = Numbers.random(start, end)
        then:   (start..end).containsWithinBounds(chosen as int)

        where:  start << Gen.integer * ITERATIONS
                end = Gen.integer(start, Integer.MAX_VALUE).next()
    }

    @Ignore('ChiSquareTest seems too unreliable')
    def 'discrete, uniform distribution, chi-squared validations for Numbers.random'() {
        when:   def range = 1..7
                def rand = { Numbers.random(range.from, range.to) as int }
        then:   hasUniformDistribution(range, rand)
    }

    def 'numBits?'(long number) {
        when:   def numBits = Numbers.bitSize(number)
        and:    def bits = 0
                for (def result = number; result > 0; result >>= 1)
                    bits++
        then:   bits == numBits

        where:  number << new LongGenerator(0, Long.MAX_VALUE) * ITERATIONS
    }
    /*@formatter:on*/
}
