package pap.lorinc.algos.ctci._2

/** Calculate the sum of two numbers, represented as a linked list of decimal digits */
class _2_5_SumLists {
    /** Complexity: O(size1 + size2), uses same amount of space */
    static sum(Node head1, Node head2) {
        def (reverse1, reverse2) = [reverse(head1), reverse(head2)]

        int carry = 0
        def result = Node.SENTINEL
        while (reverse1?.hasNext() || reverse2?.hasNext()) {
            def sum = carry + valueOrZero(reverse1) + valueOrZero(reverse2)
            result = result.addBefore(sum % 10)
            carry = sum / 10

            (reverse1, reverse2) = [reverse1?.next, reverse2?.next]
        }
        if (carry > 0) result = result.addBefore(carry)

        result
    }
    static valueOrZero(Node node) { node?.value ?: 0 }
    static reverse(Node head) { head.inject(Node.SENTINEL) { Node h, Node n -> h.addBefore(n.value) } }
}