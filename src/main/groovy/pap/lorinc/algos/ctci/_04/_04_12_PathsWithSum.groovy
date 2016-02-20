package pap.lorinc.algos.ctci._04

import pap.lorinc.algos.ctci._04.utils.BiNode

/** Return all paths in a binary tree that sum to a given value */
class _04_12_PathsWithSum {
    /** Complexity: O(root.size**2) */
    static sumPaths(BiNode root, int sum) {
        Set results = []
        iterate(root) { BiNode currentRoot ->
            def (currentPath, currentSum) = [[], 0]
            iterate(currentRoot, { BiNode<Integer> node -> // TODO some values should be precalculated (min/max?)
                currentPath += node.value
                currentSum += node.value
                if (currentSum == sum)
                    results << currentPath.clone()
            }, { currentSum -= currentPath.pop() })
        }
        results
    }

    private static iterate(BiNode node, Closure preOrder, Closure postOrder = {}) {
        if (!node) return

        preOrder(node)
        iterate(node.left, preOrder, postOrder)
        iterate(node.right, preOrder, postOrder)
        postOrder(node)
    }
}
