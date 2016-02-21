package pap.lorinc.algos.ctci._04

import pap.lorinc.algos.ctci._04.utils.BiNode

import static java.lang.Math.*

/** Check whether a binary tree is balanced */
class _04_04_CheckBalanced {
    /** Complexity: O(root.size) */
    static isBalanced(BiNode root) {
        abs(height(root.left) - height(root.right)) < 2
    }
    static height(BiNode root) {
        root ? 1 + max(height(root.left), height(root.right))
             : 0
    }
}