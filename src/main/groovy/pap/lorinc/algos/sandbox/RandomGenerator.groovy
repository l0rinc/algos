package pap.lorinc.algos.sandbox

import static pap.lorinc.algos.helpers.Numbers.*

/*
 * Given a function which produces a random integer in the range 1 to 5,
 * write one that generates in the range 1 to 7.
 **/
class RandomGenerator {
    static getRandomNumber(IntRange range) {
        def value = getRandomNumber(range.to)
        range.containsWithinBounds(value) ? value
                                          : getRandomNumber(range)
    }

    static getRandomNumber(int size) {
        def bits = getRandomBits(size)
        fromBinary(bits.join(''))
    }

    static getRandomBits(int size) { (1..numBits(size)).collect { generateRandomBit() } }
    static fromBinary(String value) { new BigInteger(value, 2).intValue() }

    static generateRandomBit() { // TODO generalize for (min..max)?
        switch (rand1_5()) {
            case [1, 2]: return 0
            case [3, 4]: return 1
            default: return generateRandomBit()
        }
    }

    @Lazy static rand = { new Random() }()
    static rand1_5() { 1 + rand.nextInt(5) }
}
