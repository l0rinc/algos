package pap.lorinc.algos.sandbox

import spock.lang.Specification

import java.time.Month
import java.time.MonthDay

import static java.time.Month.*
import static pap.lorinc.algos.sandbox.Zodiac.Values.*

@SuppressWarnings("GroovyAssignabilityCheck")
class ZodiacTest extends Specification {
    /*@formatter:off*/
    def 'Zodiacs are calculated correctly for the boundaries'(MonthDay date, Zodiac.Values zodiac) {
        expect: Zodiac.of(date) == zodiac
        where:  date         || zodiac
                DECEMBER(22) || CAPRICORN
                JANUARY(1)   || CAPRICORN

                JANUARY(20)  || CAPRICORN
                JANUARY(21)  || AQUARIUS
                JANUARY(22)  || AQUARIUS

                NOVEMBER(12) || SCORPIO
    }
    /*@formatter:on*/

    static {
        Month.metaClass.call = { int day -> MonthDay.of(delegate as Month, day) }
    }
}