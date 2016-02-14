package pap.lorinc.algos.ctci._4

import pap.lorinc.algos.ctci._4.utils.DiGraph
import spock.lang.*

import static pap.lorinc.algos.ctci._4.GraphTest.fill
import static pap.lorinc.algos.ctci._4._4_7_BuildOrder.buildOrder

@Unroll class _4_7_BuildOrderTest extends Specification {
    /*@formatter:off*/
    def 'buildOrder from #connections?'() {
        when:   def graph = fill(connections, new DiGraph())
        then:   buildOrder(graph).toList() == result

        where:
        connections                       || result
        [0:[]]                            || [0]
        [1:0]                             || [0,1]
        [2:1,1:0]                         || [0,1,2]
        [3:[2,1],2:[0,1],1:0]             || [0,1,2,3]
        [4:[3,2,1,0],3:1,2:1,1:0]         || [0,1,2,3,4]

        [3:[0,1],2:3,1:5,0:5]             || [5,0,1,3,2,4]
        [4:0,3:[0,1],2:[3,5],1:[0,5],0:5] || [5,0,1,3,2,4]
        [5:[2,1],2:0,1:[2,4],0:4,3:6]     || [4,0,2,1,6,3,5]
    }

    def 'buildOrder breaks for cycles?'() {
        when:   def graph = fill(connections, new DiGraph())
        and:    buildOrder(graph)
        then:   thrown IllegalStateException

        where:
        connections       | _
        [2:1,1:2]         | _
        [2:1,1:0,0:2]     | _
        [3:2,2:1,1:0,0:2] | _
        [3:2,2:1,1:0,0:3] | _
    }
    /*@formatter:on*/
}
