package pap.lorinc.algos.ctci._4

import pap.lorinc.algos.ctci._4.utils.BiNode

/** Given a binary tree node, find its in-order successor */
class _4_6_Successor {
    /** Complexity: O(tree.height) */
    static successor(BiNode<Integer> node) {
        descendLeft(node.right) ?: ascendRight(node).parent
    }
    static descendLeft(BiNode node) {
        while (node?.left) node = node.left
        node
    }
    private static ascendRight(BiNode node) {
        while (node?.isRightChild) node = node.parent
        node
    }
}
