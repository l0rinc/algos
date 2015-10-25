package pap.lorinc.algos;

import static java.lang.Math.multiplyExact;

public class GcdAndLcm {
    /* TODO @tailrec or iterative */
    public static long gcd(long first, long second) {
        long remainder = first % second;
        return (remainder == 0) ? second
                                : gcd(second, remainder);
    }

    public static long lcm(long first, long second) throws ArithmeticException {
        return multiplyExact(first / gcd(first, second), second);
    }
}
