package pap.lorinc.algos.ctci._2

import pap.lorinc.algos.ctci._2.utils.Node
import spock.lang.*

@Unroll class NodeTest extends Specification {
    /*@formatter:off*/
    def 'iterator?'() {
        when:   def head = Node.from(list).copy()
        then:   head.toList() == list
        where:  list        | _
                []          | _
                [1]         | _
                [1,2]       | _
                [1,2,3]     | _
                [1,2,3,4]   | _
                [1,2,3,4,5] | _
    }
    /*@formatter:on*/
}
