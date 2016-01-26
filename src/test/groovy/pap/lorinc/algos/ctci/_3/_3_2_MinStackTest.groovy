package pap.lorinc.algos.ctci._3

import spock.lang.Specification

import static java.lang.Math.*
import static pap.lorinc.algos.ctci._3._3_2_StackMin.createMinStack

class _3_2_MinStackTest extends Specification {
    /*@formatter:off*/
    def 'minStack?'() {
        given:  def source = "$PI$E".toList()

        when:   'a new stack is empty'
                def stack = createMinStack()
        then:   stack.empty

        when:   'consuming a stack yields the correct value and min'
                source.reverseEach {
                    stack.push(it)
                    assert !stack.empty
                }
        then:   source.eachWithIndex { value, i ->
                    def wrapper = stack.pop()
                    assert wrapper.value == value
                    assert wrapper.min == source[i..<source.size()].min()
                }
                stack.empty
    }
    /*@formatter:on*/
}
