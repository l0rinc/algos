package pap.lorinc.algos.ctci._04

import pap.lorinc.algos.ctci._04.utils.BiNode
import spock.lang.*

import static pap.lorinc.algos.ctci._04._04_06_SuccessorTest.collectNodes
import static pap.lorinc.algos.ctci._04._04_10_CheckSubtree.*

@Unroll class _04_10_CheckSubtreeTest extends Specification {
    /*@formatter:off*/
    def 'containsTree from #tree?'() {
        when:   def roots = collectNodes(BiNode.from(tree))
        then:   for (source in roots)
                    for (target in collectNodes(source)) {
                        assert contains_withHash(source, target) 
                        assert contains_withBfs(source, target)
                        
                        if (!source.is(target)){
                            assert !contains_withHash(target, source) 
                            assert !contains_withBfs(target, source)
                        }
                    }
        where:
        tree                                                              | _
        [1:[0]]                                                           | _
        [1:[0,2]]                                                         | _
        [2:[1,3],1:0]                                                     | _
        [3:[2,4],2:1,1:0]                                                 | _
        [4:[2,6],2:[1,3],1:0,6:[5,7]]                                     | _
        [12:[1,13],1:[0,6],6:[3,9],3:[2,5],9:[8,10],5:4,8:7,10:[null,11]] | _
    }
    /*@formatter:on*/
}
