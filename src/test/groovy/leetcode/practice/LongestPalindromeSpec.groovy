package leetcode.practice

import spock.lang.Specification

class LongestPalindromeSpec extends Specification {

    def "test algo"() {
        when:
        def result = new LongestPalindrome().longestPalindrome(input)
        and:
        def resultManacher = new LongestPalindrome().longestPalindromeWithManacher(input)
        then:
        result == expectedResult
        and:
        resultManacher == expectedResult
        where:
        input                       || expectedResult
        "abcbagabcbaeee"            || "abcbagabcba"
        "abcba"                     || "abcba"
        "bb"                        || "bb"
        "b"                         || "b"
        "abba"                      || "abba"
        "ababababababa"             || "ababababababa"
        // case 1: old left boundary equals
        "nabcballxxAxxllabcbattttt" || "abcballxxAxxllabcba"
        // case 2: old left boundary less than
        "nabcbaabcNNN"              || "cbaabc"
        // case 3: old left boundary more than
        "nabcbaNNoooooooOooooooo??" || "oooooooOooooooo"
    }
}
