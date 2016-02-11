package pap.lorinc.algos.ctci._4

import pap.lorinc.algos.ctci._4.utils.BiNode

import java.util.concurrent.atomic.AtomicInteger as Int

/** Given a binary tree, check whether it's a BST */
class _4_5_CheckBst {
    /** Complexity: O(size) */
    static isBst(BiNode<Integer> node, Int previous = new Int(Integer.MIN_VALUE)) {
        if (!node) return true
        else if (!isBst(node.left, previous) || (previous.intValue() >= node.value)) return false
        previous.set(node.value)
        isBst(node.right, previous)
    }
}