package leetcode.practice

import spock.lang.Specification

class AddTwoNumbersSpec extends Specification {

    // 9 -> 9 -> 9 + 9 -> 9 -> 9 = 8 -> 9 -> 9 -> 1
    def "test algo"() {
        when:
        def result = new AddTwoNumbers().addTwoNumbers(input1, input2)
        then:
        result == expectedResult
        where:
        input1                                            | input2                                           || expectedResult
        new ListNode(9, new ListNode(9, new ListNode(9))) | new ListNode(9, new ListNode(9, new ListNode(9))) | new ListNode(8, new ListNode(9, new ListNode(9, new ListNode(1))))
    }
}
