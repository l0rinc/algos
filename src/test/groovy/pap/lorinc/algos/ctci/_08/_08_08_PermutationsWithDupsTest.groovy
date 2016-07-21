package pap.lorinc.algos.ctci._08

import spock.lang.Specification

import static _08_08_PermutationsWithDups.permutations

class _08_08_PermutationsWithDupsTest extends Specification {
    /*@formatter:off*/
    def 'permutations?'() {
        given:  def values = 'aabbcc'.toList()
        expect: permutations(values).sort() == values.permutations().unique().sort()
    }
    /*@formatter:on*/
}