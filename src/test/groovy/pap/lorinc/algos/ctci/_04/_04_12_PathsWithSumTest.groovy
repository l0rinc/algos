package pap.lorinc.algos.ctci._04

import pap.lorinc.algos.ctci._04.utils.BiNodeBuilder
import spock.lang.*

import static pap.lorinc.algos.ctci._04._04_12_PathsWithSum.sumPaths

@Unroll class _04_12_PathsWithSumTest extends Specification {
    /*@formatter:off*/
    def 'sumList from #tree?'() {
        when:   def root = BiNodeBuilder.from(tree) 
        then:   expectedPaths.each { sum, expected -> 
                    def actual = sumPaths(root, sum)
                    assert (actual - [[sum]]) == expected.toSet() 
                }
        
        where:
        tree                                                       | expectedPaths
        [1:[0]]                                                    | [1:[[1,0]]]
        [1:[0,2]]                                                  | [1:[[1,0]]]
        [2:[1,3],1:-1]                                             | [2:[[2,1,-1]],3:[[2,1]]]
        [3:[2,4],2:0,4:-5]                                         | [2:[[3,4,-5],[2,0]],5:[[3,2],[3,2,0]]]
        [12:[1,13],1:[0,6],6:[3,9],3:[2,5],9:[8,10],5:4,8:7,10:11] | [1:[[1,0]],5:[[3,2]],7:[[1,6]],8:[[3,5]],9:[[6,3],[5,4]],10:[[1,6,3]],11:[[6,3,2]],12:[[1,6,3,2],[3,5,4]],13:[[12,1],[12,1,0]]] 
    }
    /*@formatter:on*/
}
