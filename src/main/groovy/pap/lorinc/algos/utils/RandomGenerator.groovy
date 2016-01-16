package pap.lorinc.algos.utils

class RandomGenerator {
    static generateRandomString(int size, List alphabet) {
        def random = new Random()
        (0..<size).collect { alphabet[random.nextInt(alphabet.size())] }
                  .join()
    }
}
