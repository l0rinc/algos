package pap.lorinc.algos.helpers;

import static java.lang.Math.multiplyExact;

public final class Numbers {
    private Numbers() {}

    public static boolean canDivide(long dividend, long divisor) {
        return (dividend % divisor) == 0;
    }

    public static long pow(long base, byte exponent) {
        if (exponent == 0) return 1;
        else if (exponent == 1) return base;

        long pow = pow(multiplyExact(base, base), (byte) (exponent >> 1));
        return canDivide(exponent, 2) ? pow
                                      : multiplyExact(base, pow);
    }
}
