class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode temp = head;
        for(int i = 1; i < k && temp != null; i++) {
            temp = temp.next;
        }
        if(temp == null) return head; 
        ListNode secondHead = temp.next;
        temp.next = null;
        ListNode newHead = reverse(head);
        head.next = reverseKGroup(secondHead, k);
        return newHead;
    }

    public ListNode reverse(ListNode head) {
        ListNode curr = head, prev = null, fwd = null;
        while (curr != null) {
            fwd = curr.next;
            curr.next = prev;
            prev = curr;
            curr = fwd;
        }
        return prev;
    }
}
