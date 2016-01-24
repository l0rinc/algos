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

        Node targetHead = moveLoopToStart(head, intersection)
        while (!targetHead.is(head)) {
            head = head.next
            targetHead = targetHead.next
        }
        targetHead
    }
    static moveLoopToStart(Node head, Node intersection) {
        getLoopSize(intersection).times { head = head.next }
        head
    }
    static getLoopSize(Node head) {
        def i = 1
        for (def it = head.next.iterator(); it.next() != head;)
            i++
        i
    }
}