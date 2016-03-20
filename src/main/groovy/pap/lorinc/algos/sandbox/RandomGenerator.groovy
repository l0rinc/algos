package pap.lorinc.algos.sandbox

import static pap.lorinc.algos.helpers.Numbers.bitSize

/*
 * Given a function which produces a random integer in the range 1 to 5,
 * write one that generates in the range 1 to 7.
 **/
class RandomGenerator {
    static getRandomNumber(IntRange range) {
        def candidate = range.from + getRandomNumber(range.size())
        range.containsWithinBounds(candidate) ? candidate
                                              : getRandomNumber(range)
    }

    static getRandomNumber(int magnitude) {
        def bits = getRandomBits(magnitude)
        fromBinary(bits.join())
    }

    static getRandomBits(int magnitude) { (1..bitSize(magnitude)).collect { generateRandomBit() } }
    static fromBinary(String value) { new BigInteger(value, 2).intValue() }

    static generateRandomBit() { // TODO generalize for (min..max) and for multiple values
        switch (rand1_5()) {
            case [1, 2]: return 0
            case [3, 4]: return 1
            default: return generateRandomBit()
        }
    }

    @Lazy static rand = { new Random() }()
    static rand1_5() { 1 + rand.nextInt(5) }
}
