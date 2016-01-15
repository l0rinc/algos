package pap.lorinc.algos.ctci._0

/** For a,b,c,d in 1..1000 find all, where a**3 + b**3 = c**3 + d**3
 * Complexity: O(range.size()**2)
 **/
class CubeSumEquality {
    static final RANGE = 1..1000

    static void main(String... args) {
        def sumMap = collectSumPairEntries()

        def count = 0
        iterate(sumMap.values()) { a, b, c, d -> count += 1 }
        println count
    }

    static collectSumPairEntries() {
        def sumMap = [:]
        def cubes = RANGE.collectEntries { [(it): it**3] }
        cubes.each { a, a3 ->
            cubes.each { b, b3 ->
                def sum = a3 + b3
                sumMap[sum] = sumMap.getOrDefault(sum, []) + [[a, b]]
            }
        }
        sumMap
    }

    static iterate(Collection groups, Closure closure) {
        groups.each { pairs ->
            pairs.each { a, b ->
                pairs.each { c, d ->
                    closure(a, b, c, d)
                }
            }
        }
    }
}

