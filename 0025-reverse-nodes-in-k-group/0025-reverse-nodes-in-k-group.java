class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) return head;
        int cnt = 1;
        ListNode tmp = head;
        while (cnt < k && tmp != null) {
            cnt++;
            tmp = tmp.next;
        }
        if (tmp == null) return head;
        ListNode nxtNodes = tmp.next;
        tmp.next = null;
        reverse(head);
        head.next = reverseKGroup(nxtNodes, k);
        return tmp;
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
