package pap.lorinc.algos.sort
// TODO configurable maxheap?
public final class Heap<T extends Comparable<?>> {
    private final List<T> elems
    private int size

    static <T extends Comparable<?>> Collection<T> sort(List<T> originalElems) {
        return (originalElems.size() < 2) ? originalElems
                                          : new Heap<T>(originalElems).heapSort()
    }

    private Heap(List<T> elems) {
        this.elems = elems
        this.size = elems.size()

        elems.indices.reverseEach { fixDown it }
    }

    def heapSort() {
        while (size > 1) {
            elems.swap(0, --size)
            fixDown(0)
        }
        elems
    }

    def fixDown(def elemIndex) {
        while (true) {
            def (leftIndex, rightIndex) = [leftChildIndex(elemIndex), rightChildIndex(elemIndex)]
            if (!isValidIndex(leftIndex)) break

            def childIndex = selectChildIndex(leftIndex, rightIndex)
            (elems[childIndex] > elems[elemIndex]) && elems.swap(elemIndex, childIndex)
            elemIndex = childIndex
        }
    }

    private int selectChildIndex(int leftIndex, int rightIndex) {
        (!isValidIndex(rightIndex) || (elems[leftIndex] > elems[rightIndex])
        ? leftIndex
        : rightIndex)
    }

    def isValidIndex(int index) { (0..<size).containsWithinBounds index }

    static leftChildIndex(int index) { (index << 1) + 1 }
    static rightChildIndex(int index) { leftChildIndex(index) + 1 }
}
