package leetcode.practice

import spock.lang.Specification

class ContainerWithMostWaterSpec extends Specification {

    def "test algo"() {
        when:
        def result = new ContainerWithMostWater().maxArea(input)
        then:
        result == expectedResult as int
        where:
        input                                || expectedResult
        new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7} || 49
        new int[]{4, 3, 2, 1, 4}             || 16
    }
}
