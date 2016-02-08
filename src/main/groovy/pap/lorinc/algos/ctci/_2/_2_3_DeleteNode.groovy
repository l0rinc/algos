package pap.lorinc.algos.ctci._2

import pap.lorinc.algos.ctci._2.utils.Node

/** Delete the kth element from a linked list */
class _2_3_DeleteNode {
    /** Complexity: O(index) */
    static deleteNode(Node head, int index) {
        delete(head[index])
    }
    static delete(Node head) {
        head.replace(head.next)
    }
}