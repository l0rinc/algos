package pap.lorinc.algos.ctci._02

import pap.lorinc.algos.ctci._02.utils.Node

/** Partition the elements of a linked list according to a given pivot */
class _02_04_Partition {
    /** Complexity: O(size) */
    static partition(Node head, int pivot) {
        def (lessHead, equalHead, moreHead) = [new Node(), new Node(), new Node()]
        def (lessTail, equalTail, moreTail) = [lessHead, equalHead, moreHead]

        for (def current : head)
            switch (current.value <=> pivot) {
                case -1:
                    lessTail.next = current
                    lessTail = current
                    break
                case 0:
                    equalTail.next = current
                    equalTail = current
                    break
                case +1:
                    moreTail.next = current
                    moreTail = current
                    break
                default: throw new IllegalArgumentException("${current.value <=> pivot}")
            }

        moreTail.next = Node.END_SENTINEL
        equalTail.next = moreHead.next
        lessTail.next = equalHead.next

        lessHead.next
    }
}