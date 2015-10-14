package pap.lorinc.algos.helpers;

import static java.lang.String.format;

public class Numbers {
    public static void assertDivides(long dividend, long divisor) {
        if (!divides(dividend, divisor))
            throw new IllegalStateException(format("%d is not divisible by %d", dividend, divisor));
    }

    public static boolean divides(long dividend, long divisor) {
        return (dividend % divisor) == 0;
    }
}
