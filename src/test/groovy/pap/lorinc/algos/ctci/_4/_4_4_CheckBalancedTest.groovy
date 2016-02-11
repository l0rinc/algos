package pap.lorinc.algos.ctci._4

import pap.lorinc.algos.ctci._4.utils.BiNode
import spock.lang.*

import static pap.lorinc.algos.ctci._4._4_4_CheckBalanced.isBalanced

@Unroll class _4_4_CheckBalancedTest extends Specification {
    /*@formatter:off*/
    def 'isBalanced from #tree?'() {
        when:   def bst = BiNode.from(tree)
        then:   isBalanced(bst) == result

        where:
        tree                          || result
        [0:[]]                        || true
        [1:[0]]                       || true
        [1:[0,2]]                     || true
        [2:[1,3],1:0]                 || true
        [2:[1,3],1:[0,4]]             || true
        [2:[1,4],1:0,4:3]             || true
        [3:[1,5],1:[0,2],5:4]         || true
        [3:[1,5],1:[0,2],5:[4,6]]     || true
        [4:[2,6],2:[1,3],1:0,6:[5,7]] || true

        [2:1,1:0]                     || false
        [2:[null,1],1:[null,0]]       || false
        [2:[1,3],1:[0,4],0:5]         || false
        [4:[2,6],2:[1,3],1:0]         || false
    }
    /*@formatter:on*/
}
