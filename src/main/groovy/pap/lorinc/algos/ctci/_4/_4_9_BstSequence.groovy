package pap.lorinc.algos.ctci._4

import pap.lorinc.algos.ctci._4.utils.BiNode

/** Given a BST, return all the values it could have been built from */
class _4_9_BstSequence {
    /** Complexity: O(tree.size!) */
    static sources(BiNode node, Set<BiNode> nodes = [], int size = node.size, Set results = []) {
        nodes.add(node)

        if (nodes.size() == size) results.add(nodes*.value)
        else for (n in nodes)
            for (child in ([n.left, n.right] - nodes).findAll())
                sources(child, nodes.clone(), size, results)

        results
    }
}
