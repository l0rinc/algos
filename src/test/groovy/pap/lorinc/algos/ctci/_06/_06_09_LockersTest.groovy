package pap.lorinc.algos.ctci._06

import spock.lang.*

import static java.lang.Math.sqrt
import static pap.lorinc.algos.ctci._06._06_09_Lockers.openLockers

@Unroll class _06_09_LockersTest extends Specification {
    /*@formatter:off*/
    def 'lockers?'() {
        expect: openLockers(lockerCount) == result
        where:  lockerCount || result
                100         || (0..sqrt(lockerCount)).collect{ it**2 }        
    }
    /*@formatter:on*/
}
