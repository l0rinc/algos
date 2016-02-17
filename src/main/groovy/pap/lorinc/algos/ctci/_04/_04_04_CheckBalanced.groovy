package pap.lorinc.algos.ctci._04

import pap.lorinc.algos.ctci._04.utils.BiNode

import static java.lang.Math.*

/** Given a binary tree, check whether it's balanced */
class _04_04_CheckBalanced {
    /** Complexity: O(size) */
    static isBalanced(BiNode root) {
        abs(height(root.left) - height(root.right)) < 2
    }
    static height(BiNode root) {
        root ? 1 + max(height(root.left), height(root.right))
             : 0
    }
}