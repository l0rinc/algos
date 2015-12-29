package pap.lorinc.algos.sandbox

/*
 * Write a function that transforms Excel column/row names (A,B,C,D,…,AA,AB,AC,…,BA,…,AAA…)
 * to their corresponding indices (A=1,B=2,…,AA=26,…,AAA=703).
 **/
class ExcelNaming {
    static range = 'A'..'Z'

    static excelNamesToIndices(String name) {
        name.trim().toUpperCase()
            .reverse().inject([]) { List result, String c ->
                result += valueOf(c) * range.size()**result.size()
            }
            .sum()
    }

    static valueOf(String c) { 1 + range.indexOf(c) }
}