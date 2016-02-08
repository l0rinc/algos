package pap.lorinc.algos.ctci._4

import spock.lang.*

@Unroll class GraphTest extends Specification {
    /*@formatter:off*/
    def 'graph?'() {
        when:   def graph = new Graph()
        then:   [graph.edgeCount(), graph.vertexCount()] == [0, 0]

        when:   connections.each { int from, tos ->
                    for (int to in tos)
                        graph.connect(from, to)
                }
        then:   [graph.edgeCount(), graph.vertexCount()] == [edges, vertices]

        expect: depthFirstSearchResults.each { source, targets ->
                    def values = []; DepthFirstSearch.of(graph, source) { values += it; true }
                    assert values == targets
                }
                breadthFirstSearchResults.each { source, targets ->
                    def values = []; BreadthFirstSearch.of(graph, source) { values += it; true }
                    assert values == targets
                }

        and:    connections.each { int from, tos ->
                    for (int to in tos)
                        assert graph.isConnected(from, to) && graph.isConnected(to, from)
                }

        where:
        connections                                          | vertices | edges | depthFirstSearchResults                    | breadthFirstSearchResults
        [8:[3,10],3:[1,6],6:[4,7],10:14,14:13]               | 9        | 8     | [8:[8,10,14,13,3,6,7,4,1]]                 | [8:[8,3,10,1,6,14,4,7,13]]
        [0:[1,2,5,6],5:[3,4],3:4,6:4,7:8,9:[10,11,12],11:12] | 13       | 13    | [0:[0,6,4,3,5,2,1],7:[7,8],9:[9,12,11,10]] | [0:[0,1,2,5,6,3,4],7:[7,8],9:[9,10,11,12]]
    }
    /*@formatter:on*/
}
