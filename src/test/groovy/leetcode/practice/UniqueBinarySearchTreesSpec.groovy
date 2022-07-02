package leetcode.practice

import spock.lang.Specification

class UniqueBinarySearchTreesSpec extends Specification {

    def "test algo"() {
        when:
        def result = new UniqueBinarySearchTrees().numTrees(input)
        then:
        result == expectedResult
        where:
        input || expectedResult
        1     || 1
        3     || 5
        4     || 14
    }
}
