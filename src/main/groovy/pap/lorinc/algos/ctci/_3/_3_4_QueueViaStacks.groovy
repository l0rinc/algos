package pap.lorinc.algos.ctci._3

import groovy.transform.ToString

/** Create a queue using two stacks */
@ToString(includes = 'head', includePackage = false)
class QueueViaStacks<T> {
    private main = new Stack<T>()
    private reverse = new Stack<T>()

    void add(T value) { move(reverse, main).push(value) }
    T peek() { move(main, reverse).peek() }
    T remove() { move(main, reverse).pop() }
    boolean isEmpty() { main.empty && reverse.empty }

    private static move(Stack<T> from, Stack<T> to) {
        while (!from.empty)
            to.push(from.pop())
        to
    }
}
