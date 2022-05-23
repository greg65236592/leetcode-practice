package leetcode.practice

import spock.lang.Specification

class AtoiSpec extends Specification {

    def "test algo"() {
        when:
        def result = new Atoi().myAtoi(input)
        then:
        result == expectedResult as int
        where:
        input           || expectedResult
        "00178"         || 178
        "   -78"        || -78
        "-789 fewf"     || -789
        "aaa-789 fewf"  || 0
        "-91283472332"  || -2147483648
        "-+12"          || 0
        "00000-42a1234" || 0
        "21474836460"   || 2147483647
    }
}
