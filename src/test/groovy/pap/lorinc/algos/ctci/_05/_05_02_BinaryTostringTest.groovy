package pap.lorinc.algos.ctci._05

import spock.lang.*

import static pap.lorinc.algos.ctci._05._05_02_BinaryTostring.toBinary

@Unroll class _05_02_BinaryTostringTest extends Specification {
    /*@formatter:off*/
    def 'toBinary #source is #result?'() {
        expect: toBinary(source) == result
        where:  source || result
                0.125  || '0.001' 
                0.25   || '0.01' 
                0.375  || '0.011' 
                0.5    || '0.1' 
                0.625  || '0.101' 
                0.75   || '0.11' 
                0.875  || '0.111' 
    }
    /*@formatter:on*/
}
