package pap.lorinc.algos.ctci._4

class DiGraph extends Graph {
    @Override def edgeCount() { neighbours.findAll().sum(0) { it.cardinality() } } /* TODO cache? */
    @Override void connect(int v1, int v2) {
        neighbours[v1].set(v2)
        neighbours[v2]
    }
}
