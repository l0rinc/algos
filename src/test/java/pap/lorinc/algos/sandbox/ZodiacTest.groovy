package pap.lorinc.algos.sandbox

import spock.lang.Specification

import java.time.Month
import java.time.MonthDay

import static java.time.Month.*
import static pap.lorinc.algos.sandbox.ZodiacTest.Zodiac.Values.*

@SuppressWarnings("GroovyAssignabilityCheck")
class ZodiacTest extends Specification {
    static {
        Month.metaClass.call = { int day -> MonthDay.of(delegate as Month, day) }
    }

    class Zodiac {
        enum Values {
            AQUARIUS, PISCES, ARIES, TAURUS, GEMINI, CANCER, LEO, VIRGO, LIBRA, SCORPIO, SAGITTARIUS, CAPRICORN
        }

        private static final ZODIACS = [(JANUARY(21))  : AQUARIUS,
                                        (FEBRUARY(21)) : PISCES,
                                        (MARCH(21))    : ARIES,
                                        (APRIL(21))    : TAURUS,
                                        (MAY(21))      : GEMINI,
                                        (JUNE(21))     : CANCER,
                                        (JULY(21))     : LEO,
                                        (AUGUST(21))   : VIRGO,
                                        (SEPTEMBER(21)): LIBRA,
                                        (OCTOBER(21))  : SCORPIO,
                                        (NOVEMBER(21)) : SAGITTARIUS,
                                        (DECEMBER(21)) : CAPRICORN] as TreeMap

        static of(MonthDay date) {
            def result = ZODIACS.floorEntry(date) ?: ZODIACS.lastEntry()
            result.value
        }
    }

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
}