package leetcode.practice

import spock.lang.Specification

class TwoSumSpec extends Specification {

    def "test algo"() {
        when:
        def result = new TwoSum().twoSum(input, target)
        then:
        result == expectedResult
        where:
        input              | target || expectedResult
        new int[]{3, 2, 4} | 6      || new int[]{1, 2}
    }
}
