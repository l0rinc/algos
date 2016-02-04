package pap.lorinc.algos.sandbox

import spock.lang.*

import static pap.lorinc.algos.sandbox.DivisionToString.toString

@Unroll class DivisionToStringTest extends Specification {
    /*@formatter:off*/
    def '#divident / #divisor = #result?'() {
        expect: toString(divident, divisor) == result
        where:  divident | divisor || result
                1        | 0       || null         // illegal division
                10       | 2       || '5'          // no fraction
                1        | 2       || '0.5'        // no repetition
                1        | 3       || '0.(3)'      // simple repetition
                22       | 7       || '3.(142857)' // longer repeating part
                11       | 6       || '1.8(3)'     // non-repeating fractional part

                -1       |  4      || '-0.25'      // negative divident
                 1       | -3      || '-0.(3)'     // negative divisor
                -1       | -7      || '0.(142857)' // negative both

                5        | 74      || '0.0(675)'
                1        | 28      || '0.03(571428)'
                1        | 24      || '0.041(6)'
                1        | 29      || '0.(0344827586206896551724137931)'
    }
    /*@formatter:on*/
}