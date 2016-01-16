package pap.lorinc.algos.ctci._1

import spock.lang.Specification

import static pap.lorinc.algos.ctci._1._1_1_IsUnique.isUnique
import static pap.lorinc.algos.utils.RandomGenerator.generateRandomString

class _1_1_IsUniqueTest extends Specification {
    /*@formatter:off*/
    def 'IsUnique?'() {
        when:   def referenceIsUnique = ((values as Set).size() == values.size())
        then:   isUnique(values) == referenceIsUnique
        where:  values = generateRandomString(10, 'a'..'z').collect()
    }
    /*@formatter:on*/
}
