package pap.lorinc.algos.ctci._08

import spock.lang.Specification

import static pap.lorinc.algos.ctci._08._08_06_TowersOfHanoi.move

class _08_06_TowersOfHanoiTest extends Specification {
    /*@formatter:off*/
    def 'TowersOfHanoi?'() {
        given:  def disks = 1..6
        when:   def results = move(disks)
        then:   results == disks
    }
    /*@formatter:on*/
}
