package pap.lorinc.algos.sandbox

import groovy.transform.*

import static java.lang.Math.abs
import static java.util.stream.Stream.iterate

/* Given two integers, represent their ratio as (repeating) decimals */
class DivisionToString {
    static toString(int dividend, int divisor) {
        if (divisor == 0) return null

        def isNegative = (dividend < 0) ^ (divisor < 0)
        def (history, results, distance) = [[(0): -1], [] as LinkedList, 1]
        for (step in iterate(Step.of(dividend, divisor), { Step.of(it.next, divisor) })) {
            results += step.ratio

            if (history[step.next] == null) history[step.next] = distance++
            else return toString(results, history[step.next], isNegative)
        }
    }
    static toString(LinkedList<Object> results, int repetitionStart, boolean isNegative) {
        if (repetitionStart > 0) { results.add(repetitionStart, '('); results.addLast(')') }
        if (results.size() > 1) results.add(1, '.')
        if (isNegative) results.addFirst('-')
        results.join()
    }
}

@TupleConstructor @ToString class Step {
    int ratio, next
    static of(int dividend, int divisor) { new Step(abs(dividend / divisor as int),
                                                    abs(dividend % divisor) * 10) }
}
