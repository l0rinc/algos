package pap.lorinc.algos;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import static java.lang.Math.sqrt;
import static java.lang.String.format;
import static java.util.Collections.singletonMap;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import static pap.lorinc.algos.Factorization.getFactors;
import static pap.lorinc.algos.helpers.Numbers.canDivide;
import static pap.lorinc.algos.helpers.Numbers.pow;
import static pap.lorinc.algos.helpers.Streams.stream;

public final class Factorization {
    private Factorization() {}

    public static Map<Long, Byte> getFactors(long num) throws IllegalStateException {
        if (num < 0) throw new IllegalStateException("Negative numbers not supported!");
        else if (num <= 3) return singletonMap(num, (byte) 1);

        Map<Long, Byte> results = new TreeMap<>();

        long leftover = num;
        for (long i = 2, end = (long) sqrt(num); i <= end; i++)
            while (canDivide(leftover, i)) {
                addFactor(results, i);
                leftover /= i;
            }

        if (leftover > 1)
            addFactor(results, leftover);

        return results;
    }

    private static void addFactor(Map<Long, Byte> factors, long divisor) {
        factors.put(divisor, (byte) (factors.getOrDefault(divisor, (byte) 0) + 1));
    }
}

final class FactorizationValidation {
    private FactorizationValidation() {}

    public static Map<Long, Byte> validate(Map<Long, Byte> results, long originalNumber) throws IllegalStateException {
        assertPrimeFactors(results);
        assertProductEqualsOriginal(results, originalNumber);
        return results;
    }

    private static void assertPrimeFactors(Map<Long, Byte> results) {
        List<Long> composites = stream(results).map(Entry::getKey)
                                               .filter(FactorizationValidation::isComposite)
                                               .collect(toList());
        if (composites.size() > 0)
            throw new IllegalStateException(format("Not all factors are prime: %s", composites.toString()));
    }

    private static boolean isComposite(long number) {
        return getFactors(number).size() != 1;
    }

    private static void assertProductEqualsOriginal(Map<Long, Byte> results, long originalNumber) {
        long product = stream(results).mapToLong(e -> pow(e.getKey(), e.getValue()))
                                      .reduce(1, (a, b) -> a * b);
        if (product != originalNumber)
            throw new IllegalStateException(format("%s != %s", product, originalNumber));
    }
}

final class FactorizationFormatter {
    private FactorizationFormatter() {}

    public static String formatFactors(Map<Long, Byte> factors) {
        return stream(factors).map(FactorizationFormatter::formatFactor)
                              .collect(joining(" x "));
    }

    private static String formatFactor(Entry<Long, Byte> entry) {
        Long factor = entry.getKey();
        Byte cardinality = entry.getValue();
        return (cardinality == 1) ? factor.toString()
                                  : format("%d^%d", factor, cardinality);
    }
}