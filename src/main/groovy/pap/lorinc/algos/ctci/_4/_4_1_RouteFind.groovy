package pap.lorinc.algos.ctci._4

import pap.lorinc.algos.ctci._4.utils.DiGraph

/** Find out whether there's a route between two nodes in a digraph */
class _4_1_RouteFind {
    /** Complexity: O(graph.edgeCount()) */
    static isConnected(DiGraph graph, int v1, int v2) {
        def (Set marked, Queue queue) = [[v1], [v1] as ArrayDeque]
        while (!queue.empty) {
            def node = queue.remove()
            if (node == v2) return true
            marked[node] || graph.neighbours(node).each { queue.add(it) }
            marked += node
        }
        false
    }
}