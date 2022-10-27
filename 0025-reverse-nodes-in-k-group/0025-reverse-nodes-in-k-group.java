class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode curr = head;
        for (int i = 1; i < k && curr != null; i++) curr = curr.next;
        if(curr == null) return head;
        ListNode temp = curr.next;
        curr.next = null;
        reverse(head);
        head.next = reverseKGroup(temp, k);
        return curr;
    }
    void reverse(ListNode head) {
        ListNode curr = head, fwd = null, prev = null;
        while(curr != null) {
            fwd = curr.next;
            curr.next = prev;
            prev = curr;
            curr = fwd;
        }
    }
}
