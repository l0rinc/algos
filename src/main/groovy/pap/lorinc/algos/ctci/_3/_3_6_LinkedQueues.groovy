package pap.lorinc.algos.ctci._3

import groovy.transform.*

import java.time.Instant

/** Link several queue types, so that the operations can be performed on all, collectively and separately */
class LinkedQueues {
    private queues = new HashMap<Class<Named>, Queue<Named>>().withDefault { new Queue() }
    private times = new HashMap<Named, Instant>().withDefault { Instant.now() }

    void add(Named value) {
        times[value]
        queues[value.class].add(value)
    }
    Named peek() { queues.values()*.peek().min { a, b -> times[a] <=> times[b] } }
    Named remove() { remove(peek().class) }
    def <T extends Named> T remove(Class<T> type) {
        def queue = queues[type]
        T value = queue.remove()
        times.remove(value)
        if (queue.empty)
            queues.remove(type)
        value
    }
    boolean isEmpty() { queues.isEmpty() }
}

@TupleConstructor @ToString(includePackage = false) class Named { String name }