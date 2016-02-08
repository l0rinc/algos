package pap.lorinc.algos.ctci._4

import spock.lang.*

@Unroll class GraphTest extends Specification {
    /*@formatter:off*/
    def 'graph?'() {
        when:   def graph = new Graph()
        then:   [graph.edgeCount(), graph.vertexCount()] == [0, 0]

        when:   fill(connections, graph)
        then:   [graph.edgeCount(), graph.vertexCount()] == [edges, vertices]

        expect: collect(graph, new DepthFirstSearch(), dfsResults.keySet()) == dfsResults
                collect(graph, new BreadthFirstSearch(), bfsResults.keySet()) == bfsResults

        and:    connections.each { int from, tos ->
                    for (int to in tos)
                        assert graph.isConnected(from, to) && graph.isConnected(to, from)
                }
        where:
        connections                                          | vertices | edges | dfsResults                                 | bfsResults
        [8:[3,10],3:[1,6],6:[4,7],10:14,14:13]               | 9        | 8     | [8:[8,10,14,13,3,6,7,4,1]]                 | [8:[8,3,10,1,6,14,4,7,13]]
        [0:[1,2,5,6],5:[3,4],3:4,6:4,7:8,9:[10,11,12],11:12] | 13       | 13    | [0:[0,6,4,3,5,2,1],7:[7,8],9:[9,12,11,10]] | [0:[0,1,2,5,6,3,4],7:[7,8],9:[9,10,11,12]]
    }

    def 'diGraph?'() {
        when:   def graph = new DiGraph()
        then:   [graph.edgeCount(), graph.vertexCount()] == [0, 0]

        when:   fill(connections, graph)
        then:   [graph.edgeCount(), graph.vertexCount()] == [edges, vertices]

        expect: collect(graph, new DepthFirstSearch(), dfsResults.keySet()) == dfsResults
                collect(graph, new BreadthFirstSearch(), bfsResults.keySet()) == bfsResults

        and:    connections.each { int from, tos ->
                    for (int to in tos)
                        assert graph.isConnected(from, to)
                }
        where:
        connections                                          | vertices | edges | dfsResults                                 | bfsResults
        [8:[3,10],3:[1,6],6:[4,7],10:14,14:13]               | 9        | 8     | [8:[8,10,14,13,3,6,7,4,1]]                 | [8:[8,3,10,1,6,14,4,7,13]]
        [0:[1,2,5,6],5:[3,4],3:4,6:4,7:8,9:[10,11,12],11:12] | 13       | 13    | [0:[0,6,4,5,3,2,1],7:[7,8],9:[9,12,11,10]] | [0:[0,1,2,5,6,3,4],7:[7,8],9:[9,10,11,12]]
    }
    /*@formatter:on*/

    static fill(Map connections, Graph graph) {
        connections.each { int from, tos ->
            for (int to : tos)
                graph.connect(from, to)
        }
        graph
    }
    static collect(Graph graph, Search search, Iterable vertices) {
        def results = [:]
        vertices.each { vertex ->
            def values = []
            search.search(graph, vertex) { values += it; true }
            results[vertex] = values
        }
        results
    }
}
