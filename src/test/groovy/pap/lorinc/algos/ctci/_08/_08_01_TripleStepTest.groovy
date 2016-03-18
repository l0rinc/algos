package pap.lorinc.algos.ctci._08

import spock.lang.*

import static pap.lorinc.algos.ctci._08._08_01_TripleStep.*

@Unroll class _08_01_TripleStepTest extends Specification {
    /*@formatter:off*/
    def 'tripleStep for #stepCount?'() {
        given:  result == result.unique().toSorted()
                result.each { it.sum() == stepCount }  
        
        expect: possibilities(stepCount) == result.size()  
                tribonacci(stepCount) == result.size()  
        
        where:  stepCount || result
                1         || [[1]]
                2         || [[1,1],[2]]
                3         || [[1,1,1],[2,1],[1,2],[3]]
                4         || [[1,1,1,1],[1,1,2],[1,3],[1,2,1],[2,1,1],[2,2],[3,1]]
                5         || [[1,1,1,1,1],[1,1,1,2],[1,1,2,1],[1,1,3],[1,2,1,1],[1,2,2],[1,3,1],[2,1,1,1],[2,1,2],[2,2,1],[2,3],[3,1,1],[3,2]]
    }
    /*@formatter:on*/
}
