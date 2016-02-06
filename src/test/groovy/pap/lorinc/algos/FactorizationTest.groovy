package pap.lorinc.algos

import spock.genesis.generators.values.LongGenerator
import spock.lang.*

import static pap.lorinc.algos.Factorization.getFactors
import static pap.lorinc.algos.FactorizationFormatter.formatFactors
import static pap.lorinc.algos.FactorizationValidation.validate

@Unroll class FactorizationTest extends Specification {
    private static long RANGE_END = Long.MAX_VALUE

    /*@formatter:off*/
    def 'The factors of #number are #factors'() {
        when:   def formattedFactors = formatFactors getFactors(number)
        then:   formattedFactors == factors
        where:  number              || factors
                1                   || '1'
                2                   || '2'
                4                   || '2^2'
                12                  || '2^2 x 3'
                48                  || '2^4 x 3'
                144                 || '2^4 x 3^2'
                360                 || '2^3 x 3^2 x 5'
                1024                || '2^10'
                123456789012345678  || '2 x 3^3 x 21491747 x 106377431'
                8068938047258330002 || '2 x 173 x 23320630194388237'
    }

    def 'Random numbers of different magnitude are factored to their prime multiples'(long number) {
        when:   def factors = getFactors(number)
        then:   validate(factors, number)
        where:  number << new LongGenerator(0, RANGE_END) * 1
    }
    /*@formatter:on*/
}
