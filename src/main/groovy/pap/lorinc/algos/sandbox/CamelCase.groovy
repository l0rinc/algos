package pap.lorinc.algos.sandbox

class CamelCase {
    static matching(String pattern, List<String> classNames) {
        classNames.findAll { name ->
            def p = 0;
            for (def n = 0; p < pattern.size() && n < name.size(); n++) {
                if (name[n] == pattern[p]) p++
                else if (isUpper(name[n]) == isUpper(pattern[p])) return false
            }
            p == pattern.size()
        }
    }

    private static isUpper(String s) {
        s.every { Character.isUpperCase(it as char) }
    }
}
