package pap.lorinc.algos.ctci._06

import spock.lang.*

import static pap.lorinc.algos.ctci._06._06_10_Poison.getPoisonedBottle

@Unroll class _06_10_PoisonTest extends Specification {
    /*@formatter:off*/
    def 'poison?'() {
        expect: bottleCount.times { poisonedBottle -> 
                    def test = { List<List> strips -> strips.collect { it.contains(poisonedBottle) } }
                    assert getPoisonedBottle(bottleCount, test) == poisonedBottle
                }
        where:  bottleCount | _
                1000        | _        
    }
    /*@formatter:on*/
}
