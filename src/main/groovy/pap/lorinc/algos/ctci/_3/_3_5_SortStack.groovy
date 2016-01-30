package pap.lorinc.algos.ctci._3

/** Sort a stack using another one */
class SortableStack<T> extends Stack<T> {
    void sort() { /* Selection sort */
        for (i in size()..1) {
            def (max, count) = [peek(), i]
            moveToTempAndBack({ count-- > 0 },
                              { max = [max, it].max(); true },
                              { push(max) },
                              { (max != it) || (max = null) })
        }
    }

    private size() {
        def size = 0
        moveToTempAndBack({ !empty }, { ++size; true }, {}, { true })
        size
    }

    private moveToTempAndBack(Closure<Boolean> shouldMove,
                              Closure<Boolean> shouldPushTo,
                              Closure betweenTransfers,
                              Closure<Boolean> shouldPushBack) {
        def temp = new Stack<T>()

        while (shouldMove())
            pop() with { shouldPushTo(it) && temp.push(it) }

        betweenTransfers()

        while (!temp.empty)
            temp.pop() with { shouldPushBack(it) && push(it) }
    }
}
