package pap.lorinc.algos.ctci._3

import groovy.transform.*

/** Create stack with O(1) minimum */
class _3_2_StackMin {
    static createMinStack() { new MinStack() }
}

class MinStack<T> {
    private final delegate = new Stack<MinWrapper<T>>()

    void push(T value) {
        def min = empty ? value : [value, peek().min].min()
        delegate.push(new MinWrapper<T>(value, min))
    }
    MinWrapper<T> peek() { delegate.peek() }
    MinWrapper<T> pop() { delegate.pop() }
    boolean isEmpty() { delegate.isEmpty() }
}

@TupleConstructor @ToString(includePackage = false)
class MinWrapper<T> { T value, min }