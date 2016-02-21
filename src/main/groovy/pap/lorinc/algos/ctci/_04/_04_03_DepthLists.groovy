package pap.lorinc.algos.ctci._04

import pap.lorinc.algos.ctci._04.utils.BiNode

/** Create a list from the levels of a binary tree */
class _04_03_DepthLists {
    /** Complexity: O(root.size) */
    static createDepthLists(BiNode root) {
        def levels = [[root]]
        while (true) {
            def nextLevel = levels.last().collectMany { [it.left, it.right].findAll() }
            if (nextLevel.empty) return levels*.value
            levels.push(nextLevel)
        }
    }
}