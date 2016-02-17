package pap.lorinc.algos.ctci._04

import pap.lorinc.algos.ctci._04.utils.BiNode
import spock.lang.*

import static _04_06_SuccessorTest.collectNodes
import static _04_08_FirstCommonAncestor.ancestor

@Unroll class _04_08_FirstCommonAncestorTest extends Specification {
    /*@formatter:off*/
    def 'ancestor from #tree?'() {
        when:   def nodes = collectNodes(BiNode.from(tree))
        then:   nodes.each { n ->
                    def pairs = [n, collectNodes(n.left), collectNodes(n.right)].findAll()
                    def groups = pairs.subsequences().findAll { it.size() == 2 }
                    groups*.combinations { n1, n2 ->
                        assert ancestor(n1, n2) == n
                        assert ancestor(n2, n1) == n
                    }
                }
        where:
        tree                                                              | _
        [1:[0]]                                                           | _
        [1:[0,2]]                                                         | _
        [2:[1,3],1:0]                                                     | _
        [3:[2,4],2:1,1:0]                                                 | _
        [4:[2,6],2:[1,3],1:0,6:[5,7]]                                     | _
        [12:[1,13],1:[0,6],6:[3,9],3:[2,5],9:[8,10],5:4,8:7,10:[null,11]] | _
    }
    /*@formatter:on*/
}
