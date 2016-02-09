package pap.lorinc.algos.ctci._4

import pap.lorinc.algos.ctci._4.utils.Graph

/** Given a sorted, unique array, create a balanced BST (as a Graph) */
class _4_2_MinimalTree<T> {
    /** Complexity: O(values.size()) */
    static createBst(List<Integer> values) {
        def graph = new Graph()
        createBst(graph, values)
        graph
    }
    static createBst(Graph graph, List<Integer> values) {
        def middle = (values.size() >> 1)
        for (children in [0..<middle, (middle + 1)..<values.size()])
            connect(graph, values, middle, children)
        values[middle]
    }
    private static connect(Graph graph, List<Integer> values, Integer middle, Range range) {
        isInvalid(range) || graph.connect(values[middle], createBst(graph, values[range]))
    }
    private static isInvalid(Range range) { range.empty || range.reverse }
}