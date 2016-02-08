package pap.lorinc.algos.ctci._2

import pap.lorinc.algos.ctci._2.utils.Node
import spock.lang.*

import static pap.lorinc.algos.ctci._2._2_8_Loop.loopStart

@Unroll class _2_8_LoopTest extends Specification {
    /*@formatter:off*/
    def 'loop?'() {
        when:   def loopHead = Node.from(loop)
                def head = createList(prefix, loopHead)
        then:   loopStart(head).is(loopHead)
        where:  prefix      | loop
                []          | [1]
                [1]         | [1]
                [1]         | [2,3]
                [1,2]       | [3]

                []          | [1,2,3,4,5]
                [1]         | [2,3,4,5]
                [1,2]       | [3,4,5]
                [1,2,3]     | [4,5]
                [1,2,3,4]   | [5]
                [1,2,3,4,5] | []
    }

    def 'range loop?'() {
        when:   def range = 0..100
        then:   range.each { i ->
                    def prefix = range[0..<i]
                    def loopHead = Node.from(range[i..<range.size()])
                    def head = createList(prefix, loopHead)
                    assert loopStart(head).is(loopHead)
                }
    }
    /*@formatter:on*/

    def createList(List prefix, Node loop) {
        if (loop.isValid()) loop.last().next = loop
        prefix.reverse().inject(loop) { Node head, value -> head.addBefore(value) }
    }
}
