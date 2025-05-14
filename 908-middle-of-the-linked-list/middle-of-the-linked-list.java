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
    public ListNode middleNode(ListNode head){
          ListNode slow = head;
    ListNode fast = head;
    if(size(head) % 2 != 0){
    while(fast.next != null){
    slow = slow.next;
    fast = fast.next.next;
    }
    return slow;
    }
    else{
    while(fast != null){
    slow = slow.next;
    fast = fast.next.next;
    }
    return slow;
    }
    }



  public int size(ListNode head){
        int size = 0;
        ListNode temp = head;
        while(temp != null){
        size++;
        temp = temp.next;
        }
        return size;
    }
    
}