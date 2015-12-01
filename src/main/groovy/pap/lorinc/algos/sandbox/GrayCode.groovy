package pap.lorinc.algos.sandbox

class GrayCode {
    static fromBinary(BigInteger num) {
        def bits = num.toString(2).collect { it as int }

        def gray = [bits[0]]
        for (int i = 0; i < bits.size() - 1; i++)
            gray << (bits[i] ^ bits[i + 1])

        new BigInteger(gray.join(''), 2).intValue()
    }
}
