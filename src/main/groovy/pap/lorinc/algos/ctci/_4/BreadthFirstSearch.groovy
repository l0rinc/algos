package pap.lorinc.algos.ctci._4

class BreadthFirstSearch implements Search {
    static of(Graph graph, int vertex = 0, Closure<Boolean> visit) { new BreadthFirstSearch().search(graph, vertex, visit) }

    @Override add(Deque<Integer> chain, int vertex) { chain.addLast(vertex) }
}
