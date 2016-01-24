package pap.lorinc.algos.ctci._2

/** Find the start of loop in a linked list */
class _2_8_Loop {
    static loopStart(Node head) {
        def intersection = findSelfIntersection(head)
        getLoopStart(head, intersection)
    }
    static findSelfIntersection(Node head) {
        def fast = head.iterator()
        for (def slow : head) {
            fast.next()
            if (slow.is(fast.next()))
                return slow
        }
        Node.SENTINEL
    }
    static getLoopStart(Node head, Node intersection) {
        if (!intersection.hasNext()) return Node.SENTINEL

        def targetHead = intersection.next
        while (!targetHead.is(head)) {
            head = head.next
            targetHead = targetHead.next
        }
        targetHead
    }
}