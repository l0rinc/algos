package pap.lorinc.algos;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.TreeMap;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import static java.lang.String.format;
import static java.lang.System.out;
import static java.util.Collections.singletonMap;
import static java.util.stream.Collectors.joining;
import static pap.lorinc.algos.NumberUtils.divides;
import static pap.lorinc.algos.StreamHelper.stream;

public class Factorization {
    private static final Random RAND = new Random();
    private static final long MAGNITUDE = 1000;

    public static void main(String... args) {
        long num = RAND.nextLong() % MAGNITUDE;
        out.println(format("The factors of %d are %s", num,
                           stream(getFactors(num))
                                   .map(Factorization::formatFactor)
                                   .collect(joining(" x "))));
    }

    private static Map<Long, Long> getFactors(long num) {
        if (num < 0) throw new IllegalStateException("Negative numbers not supported!");
        else if (num <= 3) return singletonMap(num, 1L);

        Map<Long, Long> results = new TreeMap<>();

        long leftover = num;
        for (long i = 2, end = (long) sqrt(num); i <= end; i++)
            while (divides(leftover, i)) {
                addFactor(results, i);
                leftover /= i;
            }

        if (leftover > 1)
            addFactor(results, leftover);

        return validate(results, num);
    }

    private static void addFactor(Map<Long, Long> factors, long divisor) {
        factors.put(divisor, factors.getOrDefault(divisor, 0L) + 1);
    }

    private static String formatFactor(Entry<Long, Long> entry) {
        Long factor = entry.getKey(), cardinality = entry.getValue();
        return (cardinality == 1) ? factor.toString()
                                  : format("%d^%d", factor, cardinality);
    }

    private static Map<Long, Long> validate(Map<Long, Long> results, long originalNumber) {
        long product = stream(results).mapToLong(e -> (long) pow(e.getKey(), e.getValue()))
                                      .reduce(1, (a, b) -> a * b);
        if (product != originalNumber)
            throw new IllegalStateException(format("%s != %s", product, originalNumber));
        else
            return results;
    }
}
