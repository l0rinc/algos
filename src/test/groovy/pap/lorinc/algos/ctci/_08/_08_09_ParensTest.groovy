package pap.lorinc.algos.ctci._08

import spock.lang.Specification

import static pap.lorinc.algos.ctci._08._08_09_Parens.parens

class _08_09_ParensTest extends Specification {
    /*@formatter:off*/
    def 'Parens'() {
        expect: parens(length).sort() == expected.sort()
        where:  length || expected
                1      || ['()']
                2      || ['()()', '(())']
                3      || ['()()()','()(())','(()())','(())()','((()))']
                4      || ['()()()()','(()(()))','(()())()','()()(())','(())()()','(((())))','(())(())','()((()))','()(())()','()(()())','(()()())','((()()))','((()))()','((())())']
    }
    /*@formatter:on*/
}