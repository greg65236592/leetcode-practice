package leetcode.practice

import spock.lang.Specification

class LengthOfLongestSubstringSpec extends Specification {

    def "test algo"() {
        when:
        def result = new LengthOfLongestSubstring().lengthOfLongestSubstring(input)
        and:
        def resultWithDeque = new LengthOfLongestSubstring().lengthOfLongestSubstringWithDeque(input)
        then:
        result == expectedResult
        and:
        resultWithDeque == expectedResult
        where:
        input        || expectedResult
        "pwwkew"     || 3
        "pwkew"      || 4
        "aab"        || 2
        "abb"        || 2
        "abba"       || 2
        "abcabca"    || 3
        " "          || 1
        "ohomm"      || 3
        "mhmabcdemm" || 7
        "qrsvbspk"   || 5
    }
}
