package pap.lorinc.algos.ctci._02

import pap.lorinc.algos.ctci._02.utils.Node
import spock.lang.*

import static _02_07_Intersection.intersection

@Unroll class _02_07_IntersectionTest extends Specification {
    /*@formatter:off*/
    def 'intersection?'() {
        when:   def intersectionHead = Node.from(suffix)
                def head1 = createList(prefix1, intersectionHead)
                def head2 = createList(prefix2, intersectionHead)
        then:   intersection(head1, head2).is(intersectionHead)
        where:  prefix1      | prefix2  | suffix
                []           | []       | []
                []           | []       | [1]
                [1]          | []       | [1]
                []           | [1]      | [1]
                [1]          | [1]      | [2]
                [1,2,3]      | [1]      | [2]
                [1]          | [1,2,3]  | [2]
                [1,2]        | [1,2]    | [2,3,4]
                [1,3,6,9,12] | [1,5,10] | [15]
    }
    /*@formatter:on*/

    def createList(List prefix, Node suffix) {
        prefix.reverse().inject(suffix) { Node head, value -> head.addBefore(value) }
    }
}