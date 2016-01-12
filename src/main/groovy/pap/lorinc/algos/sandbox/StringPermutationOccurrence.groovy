package pap.lorinc.algos.sandbox

/* Given a smaller string and a bigger string, find all the permutations of the former in the latter. */
class StringPermutationOccurrence {
    static void main(String... args) {
        def text = 'bacabcabcbacbcbcbcabcabcabcbcbcabcabc'
        def word = 'abc'
        findEachPermutation(text, word) { int pos, String chunk ->
            println "$pos: $chunk"
        }
    }

    static findEachPermutation(String text, String word, Closure closure) {
        word = sort(word)
        def wordHash = hash(word)
        def wordLength = word.size()

        def chunkHash = hash(text[0..<wordLength])
        for (pos in 0..<(text.size() - wordLength)) {
            def chunk = text[pos..<(pos + wordLength)]
            if (isPalindrome(chunkHash, wordHash, chunk, word))
                closure(pos, chunk)

            chunkHash += -hash(text[pos]) + hash(text[pos + wordLength])
        }
    }

    static isPalindrome(chunkHash, wordHash, String fragment, String word) {
        (chunkHash == wordHash) && (sort(fragment) == word)
    }

    static String sort(String word) { word.collect().sort().join('') } /* O(w log w), but could easily be O(w), since the alphabet is small, but since w is small also, it doesn't change anything */
    static hash(String s) { s.collect { it.hashCode() }.sum() }
}