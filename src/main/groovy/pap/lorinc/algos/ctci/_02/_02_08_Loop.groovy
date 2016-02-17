package pap.lorinc.algos.ctci._02

import pap.lorinc.algos.ctci._02.utils.Node

/** Find the start of loop in a linked list */
class _02_08_Loop {
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
        Node.END_SENTINEL
    }
    static getLoopStart(Node head, Node intersection) {
        if (!intersection.isValid()) return Node.END_SENTINEL

        def targetHead = intersection.next
        while (!targetHead.is(head)) {
            head = head.next
            targetHead = targetHead.next
        }
        targetHead
    }
}