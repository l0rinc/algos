package pap.lorinc.algos.ctci._04.utils

class DepthFirstSearch implements Search {
    static of(Graph graph, int vertex = 0, Closure<Boolean> visit) { new DepthFirstSearch().search(graph, vertex, visit) }

    @Override add(Deque<Integer> chain, int vertex) { chain.addFirst(vertex) }
}
