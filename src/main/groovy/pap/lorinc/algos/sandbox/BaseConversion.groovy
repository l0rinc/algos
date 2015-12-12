package pap.lorinc.algos.sandbox

import static java.lang.Character.*

class BaseConversion {
    static long fromBase(String num, int base) {
        validate(num, base)

        long offset = 1
        num.reverse().inject(0) { long result, currentDigit ->
            def value = digit(currentDigit as char, base)
            result += value * offset
            offset *= base
            result
        }
    }

    static validate(String num, int base) {
        if (base < MIN_RADIX || base > MAX_RADIX) throw new IllegalArgumentException()
        else if (num == null || num.empty) throw new IllegalArgumentException()
    }
}
