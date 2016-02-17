package pap.lorinc.algos.ctci._02

import pap.lorinc.algos.ctci._02.utils.Node
import spock.lang.*

import static _02_02_KthToLast.getKthToLast
import static java.lang.Math.*

@Unroll class _02_02_KthToLastTest extends Specification {
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
