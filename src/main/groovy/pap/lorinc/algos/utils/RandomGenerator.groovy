package pap.lorinc.algos.utils

class RandomGenerator {
    static generateRandomString(IntRange length, List alphabet) {
        def random = new Random()
        length.collect { alphabet[random.nextInt(alphabet.size())] }
              .join()
    }
}
