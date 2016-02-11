package pap.lorinc.algos.ctci._4

import pap.lorinc.algos.ctci._4.utils.BiNode

/** Given a binary tree, create a list for its levels */
class _4_3_DepthLists {
    /** Complexity: O(size) */
    static createDepthLists(BiNode root) {
        def levels = [[root]]
        while (true) {
            def nextLevel = levels.last().collectMany { [it.left, it.right].findAll() }
            if (nextLevel.empty) return levels*.value
            levels.push(nextLevel)
        }
    }
}