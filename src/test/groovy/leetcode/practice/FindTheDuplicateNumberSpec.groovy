package leetcode.practice

import spock.lang.Specification

class FindTheDuplicateNumberSpec extends Specification {

    def "test algo"() {
        when:
        def result = new FindTheDuplicateNumber().findDuplicate(input)
        then:
        result == expectedResult
        where:
        input                    || expectedResult
        new int[]{1, 3, 4, 2, 2} || 2
        new int[]{3, 1, 3, 4, 2} || 3
    }
}
