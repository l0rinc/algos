package pap.lorinc.algos.sandbox

import spock.lang.*

import static pap.lorinc.algos.sandbox.DominoSequence.longestSequence

@Unroll class DominoSequenceTest extends Specification {
    /*@formatter:off*/
    def 'longestSequence #dominoes = #result?'() {
        expect: longestSequence(dominoes) == result
        where:  values                                            || result
                [1,1]                                             || 1
                [1,1,2,1]                                         || 1
                [1,1,1,1]                                         || 2
                [1,2,2,3,2,4,4,1]                                 || 3
                [1,2,2,4,2,3,4,1]                                 || 3
                [1,2,3,4,2,4,4,1,3,1]                             || 3
                [1,2,3,4,2,4,4,1,3,1,4,5,5,9]                     || 4
                [1,2,3,4,2,4,4,1,3,1,4,5,5,9,2,6,5,3]             || 4
                [1,2,3,4,2,4,4,1,3,1,4,5,5,9,2,6,5,3,6,5,5,5,3,8] || 5
                [1,3,2,4,4,1,3,1,4,5,5,9,2,6]                     || 3
                [1,1,1,2,1,1,2,2,1,1,2,3,5,1,3,1]                 || 5
                [1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1]                 || 8
                
                dominoes = values.collate(2).collect { l, r -> Domino.of(l, r) }
    }
    /*@formatter:on*/
}
