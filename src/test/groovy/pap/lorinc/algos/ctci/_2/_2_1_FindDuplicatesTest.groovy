package pap.lorinc.algos.ctci._2

import pap.lorinc.algos.ctci._2.utils.Node
import spock.lang.*

import static java.lang.Math.*
import static pap.lorinc.algos.ctci._2._2_1_FindDuplicates.removeDuplicates

@Unroll class _2_1_FindDuplicatesTest extends Specification {
    /*@formatter:off*/
    def 'removeDuplicates?'() {
        when:   def head = Node.from(source)
                def unique = removeDuplicates(head).toList()
        then:   unique.sort() == source.toSet().sort()
        where:  source    | _
                []        | _
                [1]       | _
                [1,2]     | _
                [1,1]     | _
                [1,2,2,1] | _
                [1,2,1,2] | _
                [1,1,2,2] | _
                "$PI"     | _
                "$E"      | _
    }
    /*@formatter:on*/
}
