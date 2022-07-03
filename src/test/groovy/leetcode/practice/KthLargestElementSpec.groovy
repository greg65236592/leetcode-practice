package leetcode.practice

import spock.lang.Specification

class KthLargestElementSpec extends Specification {

    def "test algo"() {
        when:
        def result = new KthLargestElement().findKthLargest(input as int[], k)
        then:
        result == expectedResult
        where:
        input                       | k || expectedResult
        [1, 2, 3, 4, 5, 6, 7]       | 2 || 6
        [3, 2, 3, 1, 2, 4, 5, 5, 6] | 4 || 4
        [7, 6, 5, 4, 3, 2, 1]       | 2 || 6
    }
}
