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
    public ListNode removeNodes(ListNode head) {
        head = rev(head);
        int max = -1;
        
        ListNode temp = head;
        while(temp != null) {
            max = Math.max(max, temp.val);
            ListNode curr = temp.next;
            while(curr != null && curr.val < max) {
                curr = curr.next;
            }
            temp.next = curr;
            temp = temp.next;
        }
        return rev(head);
    }
    ListNode rev(ListNode head) {
        ListNode curr = head, fwd = null, prev = null;
        while(curr != null) {
            fwd = curr.next;
            curr.next = prev;
            prev = curr;
            curr = fwd;
        }
        return prev;
    }
}