package pap.lorinc.algos.ctci._4.utils

import groovy.transform.*

@TupleConstructor @ToString(includePackage = false)
class BiNode<T> {
    T value
    BiNode<T> left, right

    static from(Map<T, List<T>> values, BiNode<T> node = getRoot(values)) {
        def children = [] + values.getOrDefault(node?.value, [])
        switch (children.size()) {
            case 2: node.right = from(values, new BiNode(children[1])) /*noinspection GroovyFallthrough*/
            case 1: node.left = from(values, new BiNode(children[0])); break
            case 0: break
            default: throw new IllegalArgumentException('Not a binary tree!')
        }
        node
    }
    private static getRoot(Map<T, List<T>> values) {
        def root = (values.keySet() - values.values().flatten())
        switch (root.size()) {
            case 1: return new BiNode<T>(root.first())
            case 0: return null
            default: throw new IllegalArgumentException('Not a tree!')
        }
    }
}
