package pap.lorinc.algos.ctci._4

import pap.lorinc.algos.ctci._4.utils.Graph
import spock.lang.*

import static pap.lorinc.algos.ctci._4.GraphTest.fill
import static pap.lorinc.algos.ctci._4._4_2_MinimalTree.createBst

@Unroll class _4_2_MinimalTreeTest extends Specification {
    /*@formatter:off*/
    def 'createBst from #array?'() {
        expect: array.toSorted() == array.unique(false)

        when:   def bst = createBst(array)
                def reference = fill(result, new Graph())
        then:   bst == reference

        where:
        array                                        || result
        []                                           || [:]
        [0]                                          || [0:null]
        [0,1]                                        || [1:0]
        [0,1,2]                                      || [1:[0,2]]
        [0,1,2,3]                                    || [2:[1,3],1:0]
        [0,1,2,3,4]                                  || [2:[1,4],1:0,4:3]
        [0,1,2,3,4,5]                                || [3:[1,5],1:[0,2],5:4]
        [0,1,2,3,4,5,6]                              || [3:[1,5],1:[0,2],5:[4,6]]
        [0,1,2,3,4,5,6,7]                            || [4:[2,6],2:[1,3],1:0,6:[5,7]]

        [1,3,4,6,7,8,10,13,14]                       || [7:[4,13],4:[3,6],3:1,13:[10,14],10:8]
        [1,2,5,8,13,21,34,55,89,144,233,377,610,987] || [55:[8,377],8:[2,21],377:[144,987],2:[1,5],21:[13,34],144:[89,233],987:610]
    }
    /*@formatter:on*/
}
