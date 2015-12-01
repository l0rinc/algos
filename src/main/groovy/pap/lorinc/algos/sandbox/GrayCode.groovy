package pap.lorinc.algos.sandbox

class GrayCode {
    static fromBinary(long num) {
        num ^ (num >> 1)
    }
}
