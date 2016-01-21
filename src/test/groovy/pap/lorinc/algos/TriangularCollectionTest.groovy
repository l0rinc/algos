package pap.lorinc.algos

import spock.genesis.Gen
import spock.lang.*

@Unroll class TriangularCollectionTest extends Specification {
    /*@formatter:off*/
    def 'Initialized elements of size #fullMatrix.length coincide with original ones'(Object[][] fullMatrix, int sparseSize) {
        when:   def sparseMatrix = new TriangularCollection(fullMatrix)

        then:   sparseMatrix.sparseMatrix.size() == sparseSize
        and:    equals(sparseMatrix, fullMatrix)

        where:  fullMatrix                                                                       | sparseSize
                [[null,0], [0,null]]                                                             | 1
                [[null,0,1], [0,null,2], [1,2,null]]                                             | 3
                [[null,0,1,2], [0,null,3,4], [1,3,null,5], [2,4,5,null]]                         | 6
                [[null,0,1,2,3], [0,null,4,5,6], [1,4,null,7,8], [2,5,7,null,9], [3,6,8,9,null]] | 10
    }

    def 'Initialized elements of size #size coincide with original ones'(int size, Object[][] fullMatrix) {
        when:   def sparseMatrix = new TriangularCollection(fullMatrix)
        then:   equals(sparseMatrix, fullMatrix)

        where:  size << Gen.integer(1..1000) * 10
                fullMatrix = generateTriangularFullMatrix(size)
    }
    /*@formatter:on*/

    static void equals(TriangularCollection sparseMatrix, Object[][] fullMatrix) {
        assert sparseMatrix.size() == fullMatrix.length
        assert sparseMatrix.flatten() == fullMatrix.flatten()
    }

    static generateTriangularFullMatrix(int size) {
        Object[][] matrix = ([[null] * size] * size)*.clone()

        def current = 0;
        ([0..<size] * 2).combinations()
                        .findAll { int i, int j -> i > j }
                        .each { int i, int j -> matrix[i][j] = (matrix[j][i] = current++) }

        matrix
    }
}
