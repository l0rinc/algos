package pap.lorinc.algos.ctci._02

import pap.lorinc.algos.ctci._02.utils.Node

/** Delete the kth element from a linked list */
class _02_03_DeleteNode {
    /** Complexity: O(index) */
    static deleteNode(Node head, int index) {
        delete(head[index])
    }
    static delete(Node head) {
        head.replace(head.next)
    }
}