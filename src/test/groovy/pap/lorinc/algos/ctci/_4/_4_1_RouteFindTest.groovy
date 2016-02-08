package pap.lorinc.algos.ctci._4

import spock.lang.*

import static pap.lorinc.algos.ctci._4.GraphTest.fill
import static pap.lorinc.algos.ctci._4._4_1_RouteFind.isConnected

@Unroll class _4_1_RouteFindTest extends Specification {
    /*@formatter:off*/
    def 'isConnected?'() {
        when:   def graph = fill(connections, new DiGraph())
                def vertices = 0..<graph.vertexCount()
        then:   vertices.each { int v1 ->
                    def cluster = clusters[v1]
                    cluster.each { int v2 ->
                        assert isConnected(graph,v1, v2)
                    }
                    (clusters.values().flatten() - cluster - v1).each { int v2 ->
                        assert !isConnected(graph, v1, v2)
                    }
                }
        where:
        connections                                          | clusters
        [8:[3,10],3:[1,6],6:[4,7],10:14,14:13]               | [1:1,3:[6,7,4,1],6:[7,4],8:[10,14,13,3,6,7,4,1],10:[14,13],14:13]
        [0:[1,2,5,6],5:[3,4],3:4,6:4,7:8,9:[10,11,12],11:12] | [0:[1,2,5,6,3,4],3:4,5:[3,4],6:4,7:8,9:[10,11,12],11:12]
    }
    /*@formatter:on*/
}
