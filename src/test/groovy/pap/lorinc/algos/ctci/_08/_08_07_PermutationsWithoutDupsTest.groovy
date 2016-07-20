package pap.lorinc.algos.ctci._08

import spock.lang.Specification

import static _08_07_PermutationsWithoutDups.permutations

class _08_07_PermutationsWithoutDupsTest extends Specification {
    /*@formatter:off*/
    def 'permutations?'() {
        given:  def values = 1..6
        expect: permutations(values).sort() == values.permutations().sort()
    }
    /*@formatter:on*/
}
