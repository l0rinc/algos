package pap.lorinc.algos.ctci._1

import spock.lang.*

import static pap.lorinc.algos.ctci._1._1_5_EditDistance.isCloseEnough

@Unroll class _1_5_EditDistanceTest extends Specification {
    /*@formatter:off*/
    def 'isCloseEnough?'() {
        expect: isCloseEnough(a, b) == isCloseEnough
        where:  a       | b      || isCloseEnough
                ''      | 'a'    || true
                'a'     | ''     || true
                'pale'  | 'pale' || true
                'pale'  | 'ale'  || true
                'pale'  | 'ple'  || true
                'pale'  | 'pae'  || true
                'pale'  | 'pal'  || true
                'pales' | 'pale' || true

                'pale'  | 'bale' || true
                'pale'  | 'pala' || true

                'pale'  | 'bake' || false
                'pale'  | 'pa'   || false
                'pa'    | 'pale' || false
    }
    /*@formatter:on*/
}
