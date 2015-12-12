package pap.lorinc.algos.sandbox

import spock.lang.Specification

class BaseConversionTest extends Specification {
    /*@formatter:off*/
    def 'can decode simple bases'() {
        expect: BaseConversion.fromBase(number, base) == result
        where:  number     | base || result
                '00000'    | 2    || 0
                '00001'    | 2    || 1
                '00010'    | 2    || 2
                '00011'    | 2    || 3
                '00100'    | 2    || 4
                '00101'    | 2    || 5
                '00110'    | 2    || 6
                '00111'    | 2    || 7
                '01000'    | 2    || 8
                '01001'    | 2    || 9
                '01010'    | 2    || 10
                '01011'    | 2    || 11
                '01100'    | 2    || 12
                '01101'    | 2    || 13
                '01110'    | 2    || 14
                '01111'    | 2    || 15
                '10000'    | 2    || 16
                '10001'    | 2    || 17
                '10010'    | 2    || 18
                '10011'    | 2    || 19
                '10100'    | 2    || 20
                '10101'    | 2    || 21
                '10110'    | 2    || 22
                '10111'    | 2    || 23
                '11000'    | 2    || 24
                '11001'    | 2    || 25
                '11010'    | 2    || 26
                '11011'    | 2    || 27
                '11100'    | 2    || 28
                '11101'    | 2    || 29
                '11110'    | 2    || 30
                '11111'    | 2    || 31

                '1101001'  | 2    || 105

                '123456'   | 10   || 123456
                'DEADBEEF' | 16   || 3735928559
    }
    /*@formatter:on*/
}