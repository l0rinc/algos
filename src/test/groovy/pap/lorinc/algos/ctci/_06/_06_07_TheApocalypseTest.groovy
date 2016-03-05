package pap.lorinc.algos.ctci._06

import spock.lang.*

import static java.lang.Math.abs
import static pap.lorinc.algos.ctci._06._06_07_TheApocalypse.ratio

@Unroll class _06_07_TheApocalypseTest extends Specification {
    /*@formatter:off*/
    def 'theApocalypse?'() {
        expect: (100..1000).each { familyCount -> 
                    def result = ratio(familyCount)
                    assert abs(result - 1) < 2/10
                }
    }
    /*@formatter:on*/
}
