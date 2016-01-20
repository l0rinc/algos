package pap.lorinc.algos.ctci._2

import spock.lang.Specification

import static java.lang.Math.E
import static java.lang.Math.PI
import static pap.lorinc.algos.ctci._2._2_3_DeleteNode.deleteNode

class _2_3_DeleteNodeTest extends Specification {
    /*@formatter:off*/
    def 'delete?'() {
        expect: source.eachWithIndex { _, int i ->
                    def reference = source.toList()
                    reference.remove(i)

                    def head = Node.from(source)
                    deleteNode(head, i)

                    assert head.toList() == reference
                }
        where:  source | _
                "$PI"  | _
                "$E"   | _
    }
    /*@formatter:on*/
}
