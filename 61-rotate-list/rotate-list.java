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

 public static int size(ListNode head){
        int cnt = 0;
        ListNode t = head;
        while(t != null){
            cnt++;
            t = t.next;
        }
        return cnt;
    }
    
    public ListNode rotateRight(ListNode head, int k) { 
        if(head == null || k == 0) return head;
        int len = size(head);
        k = k % len;
        k = len-k-1;
        ListNode temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = head;
        int cnt = 0;
        ListNode t = head;
        while(cnt != k){
            t = t.next;
            cnt++;
        }
        ListNode y = t.next;
        t.next = null;
        return y;
    }



}