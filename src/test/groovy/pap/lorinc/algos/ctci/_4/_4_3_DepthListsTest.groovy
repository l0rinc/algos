package pap.lorinc.algos.ctci._4

import spock.lang.Specification
import spock.lang.Unroll

import static pap.lorinc.algos.ctci._4._4_2_MinimalTree.createBst
import static pap.lorinc.algos.ctci._4._4_3_DepthLists.createDepthLists

@Unroll class _4_3_DepthListsTest extends Specification {
    /*@formatter:off*/
    def 'createDepthLists from #array?'() {
        expect: array.toSorted() == array.unique(false)

        when:   def bst = createBst(array)
        then:   createDepthLists(bst) == result

        where:
        array                                        || result
        [0]                                          || [[0]]
        [0,1]                                        || [[1],[0]]
        [0,1,2]                                      || [[1],[0,2]]
        [0,1,2,3]                                    || [[2],[1,3],[0]]
        [0,1,2,3,4]                                  || [[2],[1,4],[0,3]]
        [0,1,2,3,4,5]                                || [[3],[1,5],[0,2,4]]
        [0,1,2,3,4,5,6]                              || [[3],[1,5],[0,2,4,6]]
        [0,1,2,3,4,5,6,7]                            || [[4],[2,6],[1,3,5,7],[0]]

        [1,3,4,6,7,8,10,13,14]                       || [[7],[4,13],[3,6,10,14],[1,8]]
        [1,2,5,8,13,21,34,55,89,144,233,377,610,987] || [[55],[8,377],[2,21,144,987],[1,5,13,34,89,233,610]]
    }
    /*@formatter:on*/
}
