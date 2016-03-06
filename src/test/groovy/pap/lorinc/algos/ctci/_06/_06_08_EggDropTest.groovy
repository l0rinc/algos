package pap.lorinc.algos.ctci._06

import spock.lang.Specification

import static pap.lorinc.algos.ctci._06._06_08_EggDrop.dropCount

class _06_08_EggDropTest extends Specification {
    /*@formatter:off*/
    def 'eggDrop?'() {
        expect:  for (floorCount in 1..100) {
                    assert dropCount(floorCount) { false } == Integer.MAX_VALUE 
                    for (breakingFloor in 1..floorCount)
                        assert dropCount(floorCount) { it >= breakingFloor } == breakingFloor 
                }
    }
    /*@formatter:on*/
}
