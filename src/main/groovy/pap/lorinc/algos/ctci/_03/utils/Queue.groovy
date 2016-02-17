package pap.lorinc.algos.ctci._03.utils

import groovy.transform.*
import pap.lorinc.algos.ctci._02.utils.Node

@EqualsAndHashCode(includes = 'head', includeFields = true) @ToString(includes = 'head', includePackage = false)
class Queue<T> {
    private Node<T> head, tail

    void add(T value) {
        if (empty) head = (tail = new Node(value))
        else tail = tail.addAfter(value)
    }
    T peek() { head.value }
    T remove() {
        T value = head.value
        head = head.next
        value
    }
    boolean isEmpty() { !head?.isValid() }
}
