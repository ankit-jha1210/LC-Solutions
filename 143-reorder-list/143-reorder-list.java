class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy, slow = dummy;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode temp = slow.next;
        slow.next = null;
        ListNode h1 = head, h2 = reverse(temp);
        while(h2 != null) {
            ListNode next = h1.next;
            h1.next = h2;
            h1 = h1.next;
            h2 = next;
        }
        
    }
    ListNode reverse(ListNode head) {
       ListNode curr = head, prev = null, fwd = null;
        while(curr != null) {
            fwd = curr.next;
            curr.next = prev;
            prev = curr;
            curr = fwd;
        }
        return prev;
    }
}