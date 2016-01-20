package pap.lorinc.algos.ctci._2

/** Delete the kth element */
class _2_3_DeleteNode {
    /** O(1) */
    static deleteNode(Node head, int index) {
        index.times { head = head.next }
        delete(head)
    }
    static delete(Node head) {
        head.replace(head.next)
    }
}