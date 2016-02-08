package pap.lorinc.algos.ctci._3

import pap.lorinc.algos.ctci._3.utils.Stack

/** Create stack with O(1) minimum */
class MinStack<T> extends Stack<T> {
    private final mins = new Stack<T>()

    @Override void push(T value) {
        (mins.empty || (value <= peekMin())) && mins.push(value) /* equal elements have to be repeated */
        super.push(value)
    }
    @Override T pop() {
        (peek() == peekMin()) && mins.pop()
        super.pop()
    }
    T peekMin() { mins.peek() }
}