package pap.lorinc.algos.ctci._04

import pap.lorinc.algos.ctci._04.utils.DiGraph

/** Find out whether there's a route between two nodes in a digraph */
class _04_01_RouteFind {
    /** Complexity: O(graph.edgeCount()) */
    static isConnected(DiGraph graph, int v1, int v2) {
        def (Set marked, queue) = [[v1], [v1] as ArrayDeque]
        while (!queue.empty) {
            def node = queue.removeFirst()
            if (node == v2) return true
            graph.neighbors(node).each { marked.add(it) && queue.addLast(it) }
        }
        false
    }
}