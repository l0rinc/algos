package pap.lorinc.algos.ctci._08

import spock.lang.Specification

import static pap.lorinc.algos.ctci._08._08_05_RecursiveMultiply.multiply

class _08_05_RecursiveMultiplyTest extends Specification {
    /*@formatter:off*/
    def 'Multiply'() {
        given:  def multipliers = 1..1000
                def multiplicands = 1..1000

        expect: for (multiplier in multipliers)
                    for (multiplicand in multiplicands) {
                        def result = multiply(multiplier, multiplicand)
                        assert result == multiplier * multiplicand
                    }
    }
    /*@formatter:on*/
}
