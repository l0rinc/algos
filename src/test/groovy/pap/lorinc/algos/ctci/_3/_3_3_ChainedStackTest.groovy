package pap.lorinc.algos.ctci._3

import spock.lang.Specification

import static java.lang.Math.*
import static pap.lorinc.algos.ctci._3._3_3_ChainedStacks.createChainedStack

class _3_3_ChainedStackTest extends Specification {
    /*@formatter:off*/
    def 'chainedStack?'() {
        given:  def source = "$PI$E".toList()

        when:   'a new stack is empty'
                def stack = createChainedStack(5)
        then:   stack.empty

        when:   'consuming a stack yields the correct value'
                source.reverseEach {
                    stack.push(it)
                    assert !stack.empty
                }
        then:   source.each { assert it == stack.pop() }
                stack.empty
    }
    /*@formatter:on*/
}
