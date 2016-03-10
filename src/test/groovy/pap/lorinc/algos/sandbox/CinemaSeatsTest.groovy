package pap.lorinc.algos.sandbox

import spock.lang.*

import static CinemaSeats.sort
import static pap.lorinc.algos.ctci._01._01_04_PalindromePermutationTest.shuffle

class CinemaSeatsTest extends Specification {
    /*@formatter:off*/
    @Unroll def 'sort seats #wrongSeats?'() {
        when:   def seats = sort(wrongSeats.toList())
        then:   assertCorrect(seats) 

        where:  wrongSeats | _
                'AA'       | _
                
                'AABB'     | _
                'ABAB'     | _
                
                'AABBCC'   | _
                'AABCCB'   | _
                'BACBCA'   | _
                
                'ABDCCDAB' | _
                'ABDCBDCA' | _
                'DBCBDAAC' | _
        
                'XNOHSCMNJYIELKFQTBEAGZPVJXSMCAUOFWBDKYGRQLZHVTDPIUWR' | _
        
                shuffle((('A'..'Z')*2).join()) | _ 
    }

    def 'sort seats property based?'() {
        when:   def seats = sort(wrongSeats.toList())
        then:   assertCorrect(seats) 

        where:  wrongSeats << permutations(5) 
    }
    /*@formatter:on*/

    static permutations(int length) {
        def couples = ('A'..'Z').subList(0, length)
        (couples * 2).permutations()
    }
    static void assertCorrect(List seats) {
        assert seats.groupBy().every { it.value.size() == 2 }

        for (i in seats.indices.step(2))
            assert seats.lastIndexOf(seats[i]) == i + 1
    }
}
