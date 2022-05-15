package leetcode.practice

import spock.lang.Specification

class ReverseIntegerSpec extends Specification {

    def "test algo"() {
        when:
        def result = new ReverseInteger().reverse(input)
        then:
        result == expectedResult
        where:
        input       || expectedResult
        123         || 321
        -123        || -321
        1534236469  || 0
        -2147483648 || 0
    }
}
