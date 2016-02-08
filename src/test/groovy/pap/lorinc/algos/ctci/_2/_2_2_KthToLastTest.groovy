package pap.lorinc.algos.ctci._2

import pap.lorinc.algos.ctci._2.utils.Node
import spock.lang.*

import static java.lang.Math.*
import static pap.lorinc.algos.ctci._2._2_2_KthToLast.getKthToLast

@Unroll class _2_2_KthToLastTest extends Specification {
    /*@formatter:off*/
    def 'kthToLast?'() {
        expect: source.eachWithIndex { Object entry, int i ->
                    def head = Node.from(source)
                    def kthToLast = getKthToLast(head, source.size() - i)
                    assert kthToLast.value == entry
                }
        where:  source | _
                "$PI"  | _
                "$E"   | _
    }
    /*@formatter:on*/
}
