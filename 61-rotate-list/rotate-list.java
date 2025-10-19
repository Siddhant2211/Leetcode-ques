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
        if(head == null) return null;
        int len = size(head);
        k = k % len;
        int [] arr = new int [len];
        ListNode temp = head;
        int i = 0;
        while(temp != null){
            arr [i++] = temp.val;
            temp = temp.next;
        }
        reverse(arr, 0, len - k - 1);
        reverse(arr, len - k, len - 1);
        reverse(arr, 0, len - 1);
        ListNode x = new ListNode(-1);
        ListNode dummy = x;
        for(int j = 0; j < len; j++){
            ListNode tri = new ListNode(arr [j]);
            x.next = tri;
            x = tri;
        }
        return dummy.next;
    }



    public void reverse(int [] arr, int l, int r){
        while(l < r){
            int temp = arr [l];
            arr [l] = arr [r];
            arr [r] = temp;
            l++;
            r--;
        }
    }
}