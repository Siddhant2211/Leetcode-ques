/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0, head);
    ListNode prev = dummy;

    while (head != null) {
      while (head.next != null && head.val == head.next.val)
        head = head.next;
      if (prev.next == head)
        prev = prev.next;
      else
        prev.next = head.next;
      head = head.next;
    }

    return dummy.next;
    }
}