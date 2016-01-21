package pap.lorinc.algos.ctci._2

/** Delete the kth element from a linked list */
class _2_3_DeleteNode {
    /** Complexity: O(1) */
    static deleteNode(Node head, int index) {
        index.times { head = head.next }
        delete(head)
    }
    static delete(Node head) {
        head.replace(head.next)
    }
}