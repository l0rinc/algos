package pap.lorinc.algos

import spock.lang.Specification
import spock.lang.Unroll

@Unroll class TriangularCollectionTest extends Specification {
    /*@formatter:off*/
    def 'Initialized elements coincide with original ones'(Object[][] fullMatrix) {
        when:   def sparseMatrix = new TriangularCollection(fullMatrix)
        then:   sparseMatrix.size() == fullMatrix.length
        and:    sparseMatrix.collect() == fullMatrix.flatten()

        where:  fullMatrix                                                                   | _
                [[null,0],[0,null]]                                                          | _
                [[null,0,1],[0,null,2],[1,2,null]]                                           | _
                [[null,0,1,2],[0,null,3,4],[1,3,null,5],[2,4,5,null]]                        | _
                [[null,0,1,2,3],[0,null,4,5,6],[1,4,null,7,8],[2,5,7,null,9],[3,6,8,9,null]] | _
    }
    /*@formatter:on*/
}
