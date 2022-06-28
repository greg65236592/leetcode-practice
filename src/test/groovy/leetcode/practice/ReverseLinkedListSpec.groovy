package leetcode.practice

import spock.lang.Specification

class ReverseLinkedListSpec extends Specification {

    def "test algo"() {
        when:
        def result = new ReverseLinkedList().reverseList(input)
        then:
        result == expectedResult
        where:
        input                                                              || expectedResult
        new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4)))) || new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(1))))
        null                                                               || null
    }
}
