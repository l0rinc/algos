package pap.lorinc.algos.ctci._03

import spock.lang.Specification

import static java.lang.Math.*

class _03_02_MinStackTest extends Specification {
    /*@formatter:off*/
    def 'minStack?'() {
        given:  def source = "$PI$E".toList()

        when:   'a new stack is empty'
                def stack = new MinStack()
        then:   stack.empty

        when:   'consuming a stack yields the correct value and min'
                source.reverseEach {
                    stack.push(it)
                    assert !stack.empty
                }
        then:   source.eachWithIndex { value, i ->
                    assert stack.peekMin() == source[i..<source.size()].min()
                    assert stack.pop() == value
                }
                stack.empty
    }
    /*@formatter:on*/
}
