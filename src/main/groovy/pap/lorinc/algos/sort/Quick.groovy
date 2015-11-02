package pap.lorinc.algos.sort

@SuppressWarnings("GrMethodMayBeStatic")
final class Quick<T extends Comparable<?>> {
    static final int SMALL_ENOUGH = 2**4
    private Quick() {}

    static <T extends Comparable<?>> Collection<T> sort(Collection<T> originalElems) {
        List<T> elems = originalElems.toList()
        sortInPlace(elems)
        elems
    }

    static <T extends Comparable<?>> void sortInPlace(List<T> elems) {
        def sort = new Quick<T>()
        sort.randomShuffle(elems)
        sort.quickSort(elems)
    }

    /** Reordering the elements randomly `guarantees` average case (i.e. `n*log(n)`) */
    def randomShuffle(List<T> elems) {
        if (elems.size() <= 1) return;

        def random = new Random()
        for (int i in (1..<elems.size()).reverse())
            elems.swap(i, random.nextInt(i))
    }

    def quickSort(List<T> elems) {
        if (elems.size() < SMALL_ENOUGH) Insertion.sortInPlace(elems)
        else {
            def pivot = pivot(elems)
            def partitions = partition(elems, pivot)

            quickSort elems.subList(0, partitions[0])
            quickSort elems.subList(partitions[1], elems.size())
        }
    }

    /** Dijkstra 3-way partitioning - takes care of duplicates */
    def partition(List<T> elems, T pivot) {
        def start = 0, end = elems.size() - 1

        for (int i = 0; i <= end;) {
            if (elems[i] < pivot) elems.swap(i++, start++)
            else if (elems[i] > pivot) elems.swap(i, end--)
            else i++
        }

        [start, end + 1]
    }

    def pivot(List<T> elems) { elems[elems.size() >> 1] }
}