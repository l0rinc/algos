package pap.lorinc.algos.helpers;

import java.math.BigInteger;
import java.util.Random;

import static java.lang.Math.multiplyExact;

public final class Numbers {
    private Numbers() {}

    public static boolean canDivide(long dividend, long divisor) {
        return (dividend % divisor) == 0;
    }

    public static boolean isEven(long dividend) {
        return (dividend & 1) == 0;
    }

    public static boolean isOdd(long dividend) {
        return !isEven(dividend);
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

    /**
     * Probabilistic primality test based on Fermat's little theorem, i.e.
     * <pre>{@code
     *   if p is prime and 0 < b < p, then
     *   b^(p-1) mod p ≡ 1
     * }</pre>
     */
    public static boolean isProbablePrime(long number, short probability) {
        assertPositive(number, probability);

        if (number < 2) return false;
        long previousNumber = number - 1;

        Random random = new Random();
        for (int i = 0; i < probability; i++) {
            long chosen = random(random, 1, previousNumber);
            long pow = pow(chosen, (int) previousNumber, number);
            if (pow != 1)
                return false;
        }

        return true;
    }

    public static long random(long startInclusive, long endInclusive) {
        return random(new Random(), startInclusive, endInclusive);
    }

    public static long random(Random random, long startInclusive, long endInclusive) {
        if (startInclusive > endInclusive) throw new IllegalArgumentException("`startInclusive` should be less than `endInclusive`!");

        long chosen = Long.MAX_VALUE;
        for (long size = endInclusive - startInclusive; chosen > size; )
            chosen = random(random, size);
        return startInclusive + chosen;
    }

    public static long random(Random random, long size) {
        int numBits = bitSize(size);
        return new BigInteger(numBits, random).longValue();
    }

    public static int bitSize(long number) {
        assertPositive(number);
        return Long.SIZE - Long.numberOfLeadingZeros(number);
    }

    private static void assertPositive(long... numbers) {
        for (long number : numbers)
            if (number < 0)
                throw new IllegalArgumentException("Negative values not supported!");
    }
}
