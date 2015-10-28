package pap.lorinc.algos.helpers;

import static java.lang.Math.multiplyExact;

public final class Numbers {
    private Numbers() {}

    public static boolean canDivide(long dividend, long divisor) {
        return (dividend % divisor) == 0;
    }

    public static boolean isEven(long dividend) {
        return (dividend & 1) == 0;
    }

    public static long pow(long base, byte exponent) {
        return pow(base, exponent, Long.MAX_VALUE);
    }

    public static long pow(long base, int exponent, long modulo) {
        assertPositive(base, exponent, modulo);

        if (exponent == 0) return mul(1, 1, modulo);
        else if (exponent == 1) return mul(base, 1, modulo);

        long pow = pow(mul(base, base, modulo), exponent >>> 1, modulo);
        return isEven(exponent) ? pow
                                : mul(base, pow, modulo);
    }

    public static long mul(long first, long second, long modulo) {
        long product = multiplyExact(first, second);
        return product % modulo;
    }

    public static int maxExponent(long number) {
        assertPositive(number);
        return (int) (Math.log(Long.MAX_VALUE) / Math.log(number));
    }

    private static void assertPositive(long... numbers) {
        for (long number : numbers)
            if (number < 0)
                throw new IllegalArgumentException("Negative values not supported!");
    }
}
