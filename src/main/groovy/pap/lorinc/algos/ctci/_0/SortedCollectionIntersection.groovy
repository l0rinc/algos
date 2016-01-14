package pap.lorinc.algos.ctci._0

/** Given two sorted lists, find their intersection
 ** Complexity: O(min(first.size(), second.size())
 **/
class SortedCollectionIntersection {
    static <T> List intersection(Collection<T> first, Collection<T> second) {
        def results = []

        def (i, j) = [0, 0]
        while ((i < first.size()) && (j < second.size())) {
            def (f, s) = [first[i], second[j]]
            switch (f <=> s) {
                case -1: i++; break
                case 0:
                    results += f
                    i++
                    j++
                    break
                case 1: j++; break
            }
        }

        results
    }
}