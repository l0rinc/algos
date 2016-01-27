package pap.lorinc.algos.ctci._3
/** Create stack with O(1) minimum */
class _3_2_MinStack {
    static createMinStack() { new MinStack() }
}

class MinStack<T> extends Stack<T> {
    private final mins = new Stack<T>()

    @Override void push(T value) {
        if (mins.empty || (value <= peekMin())) /* equal elements have to be repeated */
            mins.push(value)
        super.push(value)
    }
    @Override T pop() {
        if (peek() == peekMin())
            mins.pop()
        super.pop()
    }
    T peekMin() { mins.peek() }
}