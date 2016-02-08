package pap.lorinc.algos.ctci._4

import pap.lorinc.algos.ctci._4.utils.*

/** Find out whether there's a route between two nodes in a digraph */
class _4_1_RouteFind<T> {
    /** Complexity: O(graph.edgeCount()) */
    static isConnected(DiGraph graph, int v1, int v2) {
        v2 == BreadthFirstSearch.of(graph, v1) { it != v2 }
    }
}