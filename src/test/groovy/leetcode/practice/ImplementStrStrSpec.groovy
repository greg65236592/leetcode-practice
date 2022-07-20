package leetcode.practice

import spock.lang.Specification

class ImplementStrStrSpec extends Specification {

    def "test algo"() {
        when:
        def result = new ImplementStrStr().strStr(haystack, needle)
        then:
        result == expectedResult
        where:
        haystack | needle || expectedResult
        "hello"  | "ll"   || 2
        "l"      | "l"    || 0
        "lab"    | "ba"   || -1
    }
}
