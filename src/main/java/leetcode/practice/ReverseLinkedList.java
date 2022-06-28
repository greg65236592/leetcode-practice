package leetcode.practice;

/**
 * https://leetcode.com/problems/reverse-linked-list/
 *
 * <p>Given the head of a singly linked list, reverse the list, and return the reversed list.
 *
 * <pre>
 * Input: head = [1,2,3,4,5]
 * Output: [5,4,3,2,1]
 * </pre>
 */
public class ReverseLinkedList {

  public ListNode reverseList(ListNode head) {
    if (head == null) {
      return null;
    }
    ListNode currentNode = head;
    ListNode newNode;
    ListNode previousNode = null;
    do {
      if (previousNode != null) newNode = new ListNode(currentNode.val, previousNode);
      else newNode = new ListNode(currentNode.val);
      previousNode = newNode;
      currentNode = currentNode.next;
    } while (currentNode != null);
    return newNode;
  }
}
