package pap.lorinc.algos.ctci._04

import pap.lorinc.algos.ctci._04.utils.BiNode

import static java.lang.Math.*

/** Check whether a binary tree is balanced */
class _04_04_CheckBalanced {
    /** Complexity: O(root.size) */
    static isBalanced(BiNode root) {
        !root || (isBalanced(root.left)
               && areBalanced(height(root.left), height(root.right))
               && isBalanced(root.right))
    }
    static boolean areBalanced(int leftHeight, int rightHeight) { abs(leftHeight - rightHeight) < 2 }
    static height(BiNode root) {
        root ? 1 + max(height(root.left), height(root.right))
             : 0
    }
}