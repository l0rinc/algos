package pap.lorinc.algos.sandbox

import java.time.*

import static java.time.Month.*
import static pap.lorinc.algos.sandbox.Zodiac.Values.*

@SuppressWarnings("GroovyAssignabilityCheck")
class Zodiac {
    static {
        Month.metaClass.call = { int day -> MonthDay.of(delegate as Month, day) }
    }

    enum Values {
        AQUARIUS, PISCES, ARIES, TAURUS, GEMINI, CANCER, LEO, VIRGO, LIBRA, SCORPIO, SAGITTARIUS, CAPRICORN
    }

    private static ZODIACS = [(JANUARY(21))  : AQUARIUS,
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
