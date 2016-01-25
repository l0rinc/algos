package pap.lorinc.algos.ctci._3

import groovy.transform.*
import pap.lorinc.algos.ctci._2.Node

@EqualsAndHashCode @ToString(includePackage = false)
class Stack<T> {
    private Node<T> head = Node.END_SENTINEL

    void push(T value) { head = head.addBefore(value) }
    T peek() { head.value }
    T pop() {
        T value = head.value
        head = head.next
        value
    }
    boolean isEmpty() { !head?.isValid() }
}
