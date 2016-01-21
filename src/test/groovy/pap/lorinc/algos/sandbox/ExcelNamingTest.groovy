package pap.lorinc.algos.sandbox

import spock.lang.*

@Unroll class ExcelNamingTest extends Specification {
    /*@formatter:off*/
    def 'Excel name indices are correct: #name = #result'() {
        expect: result == ExcelNaming.excelNamesToIndices(name)
        where:  name  || result
                'A'   || 1
                'Z'   || 26
                'AA'  || 27
                'AAA' || 703
                'BAA' || 1379
                'CBA' || 3*26**2 + 2*26 + 1
                'ZZZ' || 26**3 + 26**2 + 26
    }
    /*@formatter:on*/
}