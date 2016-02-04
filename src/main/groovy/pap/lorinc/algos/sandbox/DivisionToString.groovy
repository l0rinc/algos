package pap.lorinc.algos.sandbox

import groovy.transform.ToString

import static java.lang.Math.abs

/* Given two integers, represent their ratio as (repeating) decimals */
class DivisionToString {
    static toString(int dividend, int divisor) {
        if (divisor == 0) return null

        def isNegative = (dividend < 0) ^ (divisor < 0)
        def (Map history, LinkedList results, int distance) = [[(0): -1], [], 1]
        for (step in getSteps(abs(dividend), abs(divisor))) {
            results += step.ratio

            def previousStep = history[step.next]
            if (previousStep == null) history[step.next] = distance++
            else return toString(results, previousStep, isNegative)
        }
    }
    static getSteps(int dividend, int divisor) {
        new Iterator<DivisionStep>() {
            def current = new DivisionStep(dividend, divisor)
            @Override boolean hasNext() { true }
            @Override DivisionStep next() {
                def result = this.current
                this.current = new DivisionStep(result.next, divisor)
                result
            }
        }
    }
    static toString(LinkedList<Object> results, int repetitionStart, boolean negative) {
        if (repetitionStart >= 0) {
            results.add(repetitionStart, '(')
            results.addLast(')')
        }
        if (results.size() > 1) results.add(1, '.')
        if (negative) results.addFirst('-')
        results.join()
    }
}

@ToString class DivisionStep {
    int ratio, next

    DivisionStep(int dividend, int divisor) {
        this.ratio = dividend / divisor
        this.next = (dividend % divisor) * 10
    }
}
