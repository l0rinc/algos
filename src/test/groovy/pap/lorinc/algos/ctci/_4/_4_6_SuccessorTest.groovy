package pap.lorinc.algos.ctci._4

import pap.lorinc.algos.ctci._4.utils.BiNode
import spock.lang.*

import static pap.lorinc.algos.ctci._4._4_6_Successor.successor

@Unroll class _4_6_SuccessorTest extends Specification {
    /*@formatter:off*/
    def 'successor from #tree?'() {
        given:  def root = BiNode.from(tree)
                def nodes = collectNodes(root)

        when:   def vertices = nodes*.value
                def size = vertices.max()
        then:   vertices.size() - 1 == size

        when:   def expectedSuccessors = (1..size) + null
        then:   nodes.collect { successor(it) }*.value == expectedSuccessors

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

    static collectNodes(BiNode node) {
        Set<BiNode> nodes = [node]
        while (true)
            if (nodes.every { !nodes.add(it?.left) && !nodes.add(it?.right) })
                return nodes.findAll { it != null }.sort { it.value }.collect()
    }
}
