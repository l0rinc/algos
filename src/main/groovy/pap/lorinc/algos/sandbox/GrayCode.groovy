package pap.lorinc.algos.sandbox

class GrayCode {
    static fromBinary(long num) {
        num ^ (num >> 1)
    }

    static toBinary(BigInteger num) {
        def bits = num.toString(2).collect { it as int }

        def gray = [bits[0]]
        (1..<bits.size()).each { int i ->
            gray << (gray.last() ^ bits[i])
        }

        new BigInteger(gray.join(), 2).intValue()
    }
}
