package pap.lorinc.algos.ctci._04

import pap.lorinc.algos.ctci._04.utils.BiNode

import java.util.concurrent.atomic.AtomicInteger as Int

/** Check whether a binary tree is a BST */
class _04_05_CheckBst {
    /** Complexity: O(node.size) */
    static isBst(BiNode<Integer> node, Int previous = new Int(Integer.MIN_VALUE)) { // we need a mutable previous, as we need to send messages between nodes that are visited one after the other
        if (!node) return true
        else if (!isBst(node.left, previous) || (previous.get() >= node.value)) return false
        previous.set(node.value)
        isBst(node.right, previous)
    }
}