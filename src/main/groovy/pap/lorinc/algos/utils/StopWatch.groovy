package pap.lorinc.algos.utils

import java.time.Duration
import java.time.Instant

class StopWatch {
    static List run(Closure closure) {
        def start = now()
        def result = closure.call()
        def elapsed = Duration.between(start, now())
        [result, elapsed]
    }

    private static now() {
        Instant.now()
    }
}
