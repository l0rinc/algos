package pap.lorinc.algos.ctci._0

/** Given a smaller string and a bigger string, find all the permutations of the former in the latter.
 ** Complexity: O(text.size())
 **/
class StringPermutationOccurrence {
    static void main(String... args) {
        def text = 'bacabcabcbacbcbcbcabcabcabcbcbcabcabc'
        def word = 'abc'
        findEachPermutation(text, word) { int pos, String chunk ->
            println "$pos: $chunk"
        }
    }

    static findEachPermutation(String text, String word, Closure closure) {
        def sortedWord = sortChars(word)
        def wordHash = charSetHash(sortedWord)
        def wordLength = sortedWord.size()

        findEachPermutation(text, sortedWord, wordHash, wordLength, closure)
    }

    static findEachPermutation(String text, String sortedWord, int wordHash, int wordLength, Closure closure) {
        def chunkHash = charSetHash(text[0..<wordLength])
        for (pos in 0..<(text.size() - wordLength)) {
            def chunk = { text[pos..<(pos + wordLength)] }
            if (isPermutation(chunkHash, wordHash, chunk, sortedWord))
                closure(pos, chunk())

            chunkHash = mergeHashes(chunkHash,
                                    charSetHash(text[pos]),
                                    charSetHash(text[pos + wordLength]))
        }
    }

    static isPermutation(int chunkHash, int wordHash, Closure chunk, String sortedWord) {
        (chunkHash == wordHash) && (sortChars(chunk()) == sortedWord)
    }

    static sortChars(String word) { word.collect().sort().join('') }
    static charSetHash(String s) { mergeHashes(s*.hashCode() as int[]) }
    static mergeHashes(int ... hashes) { hashes.inject { a, b -> a ^ b } }
}