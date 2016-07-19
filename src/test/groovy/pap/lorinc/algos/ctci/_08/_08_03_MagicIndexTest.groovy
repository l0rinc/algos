package pap.lorinc.algos.ctci._08

import spock.lang.*

import static pap.lorinc.algos.ctci._08._08_03_MagicIndex.magicIndex

@Unroll class _08_03_MagicIndexTest extends Specification {
    /*@formatter:off*/
    def 'magic index for #values?'() {
        when:   def index = magicIndex(values)
        then:   index == result

        where:  values                         || result
                [0]                            || 0
                [-1,1]                         || 1
                [-1,0,2]                       || 2
                [-10,-5,1,3]                   || 3
                [-3,-1,1,3,5,7]                || 3
                [-4,-2,0,2,4,6]                || 4
                [-5,-3,-1,1,3,5,7]             || 5
                [-6,-4,-2,0,2,4,6]             || 6
                [-40,-20,-1,1,2,3,5,7,9,12,13] || 7

                [0,2,3]                        || 0
                [1,2,2]                        || 2
                [-1,0,1,3,5]                   || 3
                [3,3,3,3,3]                    || 3
                [-1,0,3,3,3]                   || 3
                [9,9,9,9,9,9,9,9,9,9,9,9,9,9]  || 9
                [-10,-5,2,2,2,3,4,7,9,12,13]   || 2

                [-10,-5,0,5,10]                || null
                [-1,0]                         || null
    }
    /*@formatter:on*/
}
