package pap.lorinc.algos.sandbox

import groovy.transform.ToString
import jdk.nashorn.internal.ir.annotations.Immutable

/* Given two integers, represent their ratio as (repeating?) decimals */
class DivisionToString {
    static toString(int dividend, int divisor) {
        if (divisor == 0) return null

        def (LinkedHashMap steps, LinkedList results, int currentStep) = [[(0): -1], [], 0]
        for (step in getSteps(dividend, divisor)) {
            results += step.ratio

            def previousStep = steps[step.next]
            steps[step.next] = ++currentStep

            if (previousStep != null)
                return toString(results, previousStep)
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
    static toString(LinkedList results, int repetitionStart) {
        if (repetitionStart >= 0) {
            results.add(repetitionStart, '(')
            results.add(')')
        }
        if (results.size() > 1) results.add(1, '.')
        results.join()
    }
}

@Immutable @ToString class DivisionStep {
    int ratio, next

    DivisionStep(int dividend, int divisor) {
        this.ratio = dividend / divisor
        this.next = (dividend % divisor) * 10
    }
}
