package pap.lorinc.algos.ctci._4

trait Search {
    def search(Graph graph, int vertex, Closure<Boolean> visit) {
        def (marked, chain) = [new BitSet(), new ArrayDeque<Integer>()]
        marked.set(vertex)

        while (true) {
            graph.neighbours(vertex)
                 .findAll { !marked[it] }
                 .each {
                    add(chain, it)
                    marked.set(it)
                 }

            if (!visit(vertex)) return vertex
            else if (chain.empty) return null

            vertex = chain.removeFirst()
        }
    }

    abstract add(Deque<Integer> chain, int vertex)
}