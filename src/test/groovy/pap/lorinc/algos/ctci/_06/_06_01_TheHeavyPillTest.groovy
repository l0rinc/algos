package pap.lorinc.algos.ctci._06

import spock.lang.*

import static pap.lorinc.algos.ctci._06._06_01_TheHeavyPill.index

@Unroll class _06_01_TheHeavyPillTest extends Specification {
    /*@formatter:off*/
    def 'heavyPill?'() {
        expect: bottleCount.times { i ->
                    def bottleWeights = [normalWeight] * bottleCount
                    bottleWeights[i] = differentWeight
            
                    assert index(bottleWeights, normalWeight, differentWeight) == i
                }
        where:  bottleCount | normalWeight | differentWeight
                20          | 1.0          | 1.1        
                20          | 1.1          | 1.0        
                5           | 2.7182818284 | 3.1415926535        
    }
    /*@formatter:on*/
}
