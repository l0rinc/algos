package pap.lorinc.algos.ctci._4

import java.util.stream.Stream

class Graph {
    private List<BitSet> neighbours = [].withDefault { new BitSet(0) }

    def vertexCount() { neighbours.findAll().size() }                        /* TODO cache? */
    def edgeCount() { neighbours.findAll().sum(0) { it.cardinality() } / 2 } /* TODO cache? */
    void connect(int v1, int v2) {
        neighbours[v1].set(v2)
        neighbours[v2].set(v1)
    }
    def isConnected(int v1, int v2) { isValid(v1) && neighbours[v1].get(v2) }
    def neighbours(int v) { isValid(v) ? neighbours[v].stream() : Stream.empty() }
    private isValid(int v) { (v >= 0) && (v < neighbours.size()) }
}
