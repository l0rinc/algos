package pap.lorinc.algos.ctci._08

/** */
class _08_09_Parens {
    static parens(int level, String result = '', List<String> results = [], int shouldOpen = level, int shouldClose = 0) {
        if (result.size() == 2 * level)
            results << result.toString()
        else {
            if (shouldOpen > 0)
                parens(level, result + '(', results, shouldOpen - 1, shouldClose + 1)
            if (shouldClose > 0)
                parens(level, result + ')', results, shouldOpen, shouldClose - 1)
        }
        results
    }
}