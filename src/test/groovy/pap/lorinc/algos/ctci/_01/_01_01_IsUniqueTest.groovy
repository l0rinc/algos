package pap.lorinc.algos.ctci._01

import spock.lang.Specification

import static _01_01_IsUnique.isUnique
import static pap.lorinc.algos.utils.RandomGenerator.generateRandomString

class _01_01_IsUniqueTest extends Specification {
    /*@formatter:off*/
    def 'IsUnique?'() {
        when:   def referenceIsUnique = (values.unique(false) == values)
        then:   isUnique(values) == referenceIsUnique
        where:  values = generateRandomString(10, 'a'..'z').toList()
    }
    /*@formatter:on*/
}
