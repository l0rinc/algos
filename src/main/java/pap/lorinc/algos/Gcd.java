package pap.lorinc.algos;

import java.util.Random;

import static java.lang.String.format;
import static java.lang.System.out;
import static pap.lorinc.algos.NumberUtils.assertDivides;

public class Gcd {
    private static final Random RAND = new Random();
    private static final int MAGNITUDE = 100;

    public static void main(String... args) {
        int first = RAND.nextInt(MAGNITUDE), second = RAND.nextInt(MAGNITUDE);

        printGcd(first, second);
        printLcm(first, second);
    }

    private static void printGcd(int first, int second) {
        int gcd = gcd(first, second);
        assertDivides(first, gcd);
        assertDivides(second, gcd);
        out.println(format("Gcd of %s and %s is %s", first, second, gcd));
    }

    private static void printLcm(int first, int second) {
        int lcm = lcm(first, second);
        assertDivides(lcm, first);
        assertDivides(lcm, second);
        if (lcm > first * second) throw new IllegalStateException();
        out.println(format("Lcm of %s and %s is %s", first, second, lcm));
    }


    /* TODO @tailrec or iterative */
    private static int gcd(int first, int second) {
        int remainder = first % second;
        return (remainder == 0) ? second
                                : gcd(second, remainder);
    }

    private static int lcm(int first, int second) {
        return first / gcd(first, second) * second;
    }
}
