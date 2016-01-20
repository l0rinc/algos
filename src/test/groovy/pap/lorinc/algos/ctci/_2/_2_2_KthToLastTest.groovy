package pap.lorinc.algos.ctci._2

import spock.lang.Specification

import static java.lang.Math.E
import static java.lang.Math.PI
import static pap.lorinc.algos.ctci._2._2_2_KthToLast.getKthToLast

class _2_2_KthToLastTest extends Specification {
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
