package pap.lorinc.algos.ctci._08

import spock.lang.*

import static pap.lorinc.algos.ctci._08._08_04_PowerSet.subsets

@Unroll class _08_04_PowerSetTest extends Specification {
    /*@formatter:off*/
    def 'subsets?'(Set values) {
        given:  def expected = values.toList().subsequences()*.toSet().toSet()

        when:   def sets = subsets(values)
        then:   sets == expected

        where:  values      || _
                []          || _
                [0]         || _
                [0,1]       || _
                [1,2,3]     || _
                [1,2,3,4]   || _
                [1,2,3,4,5] || _
    }
    /*@formatter:on*/
}