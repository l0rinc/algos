package pap.lorinc.algos;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

import static java.lang.Math.sqrt;

public final class PrimeSieve {
    private PrimeSieve() {}

    public static List<Integer> getPrimesUntil(int limit) {
        limit += 1;
        BitSet sieve = new BitSet(limit);

        excludeEvens(sieve, limit);
        excludeRest(sieve, limit);

        return collectPrimes(sieve, limit);
    }

    private static void excludeEvens(BitSet sieve, int limit) {
        for (int i = 4; i < limit; i += 2)
            sieve.set(i);
    }

    /**
     * We don't check the multiples of non-primes.
     * We start the exclusion with i^2, since the rest have lower factors that have already been excluded.
     * Therefore we only have to go to sqrt(LIMIT) in the main loop (i^2 < LIMIT).
     * Also, since the evens have already been crossed out, we increment by 2 and 2*i.
     */
    private static void excludeRest(BitSet sieve, int limit) {
        for (int i = 3, end = (int) sqrt(limit); i <= end; i += 2)
            if (!sieve.get(i))
                for (int j = i * i; j < limit; j += 2 * i)
                    sieve.set(j);
    }

    private static List<Integer> collectPrimes(BitSet sieve, int limit) {
        List<Integer> results = new ArrayList<>();
        for (int i = 2; i < limit; i = sieve.nextClearBit(i + 1))
            results.add(i);
        return results;
    }
}