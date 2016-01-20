package pap.lorinc.algos.ctci._2

/** Return the kth element from the end */
class _2_2_KthToLast {
    static getKthToLast(Node head, int reverseIndex) {
        def withSize = getKthToLast1(head, reverseIndex)
        def withRunner = getKthToLast2(head, reverseIndex)

        assert withSize == withRunner

        withSize
    }

    /** O(size), uses one counter two times */
    static getKthToLast1(Node head, int reverseIndex) {
        def size = head.count { it }
        (size - reverseIndex).times { head = head.next }
        head
    }

    /** O(size), uses two counters at the same time */
    static getKthToLast2(Node head, int reverseIndex) {
        def runner = head
        reverseIndex.times { runner = runner.next }

        runner.each { head = head.next }

        head
    }
}