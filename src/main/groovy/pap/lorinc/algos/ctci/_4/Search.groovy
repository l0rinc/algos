package pap.lorinc.algos.ctci._4

trait Search {
    void search(Graph graph, int vertex, Closure<Boolean> visit) {
        def (marked, chain) = [new BitSet(), new ArrayDeque<Integer>()]
        marked.set(vertex)

        while (true) {
            graph.neighbours(vertex)
                 .findAll { !marked[it] }
                 .each {
                    add(chain, it)
                    marked.set(it)
                 }

            if (!visit(vertex) || chain.empty) return
            vertex = chain.removeFirst()
        }
    }

    abstract add(Deque<Integer> chain, int vertex)
}