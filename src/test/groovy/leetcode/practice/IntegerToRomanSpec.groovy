package leetcode.practice

import spock.lang.Specification

class IntegerToRomanSpec extends Specification {

    def "test algo"() {
        when:
        def result = new IntegerToRoman().intToRoman(input)
        then:
        result == expectedResult
        where:
        input || expectedResult
        1994  || "MCMXCIV"
        3999  || "MMMCMXCIX"
        1     || "I"
        3     || "III"
        58    || "LVIII"
    }
}
