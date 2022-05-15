package leetcode.practice;

import lombok.Data;

/**
 * https://leetcode.com/problems/add-two-numbers/
 *
 * <pre>
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 * </pre>
 */
public class AddTwoNumbers {

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode result = null;
    ListNode currentNode = null;
    int quotient = 0;
    while (l1 != null || l2 != null || quotient != 0) {
      int cur = 0;
      if (l1 != null) {
        cur += l1.val;
        l1 = l1.next;
      }
      if (l2 != null) {
        cur += l2.val;
        l2 = l2.next;
      }
      int total = (quotient + cur);
      int remainder = total % 10;
      quotient = total / 10;
      if (result == null) {
        result = new ListNode(remainder);
        currentNode = result;
      } else {
        currentNode.next = new ListNode(remainder);
        currentNode = currentNode.next;
      }
    }
    return result;
  }
}

@Data
class ListNode {
  int val;
  ListNode next;

  ListNode() {}

  ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }
}
