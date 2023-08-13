class Solution {

    public ListNode doubleIt(ListNode head) {
        head = rev(head);
        ListNode temp = head;
        ListNode prev = null;
        int carry = 0;
        while (temp != null) {
            int res = 2 * temp.val + carry;
            temp.val = res % 10;
            carry = res / 10;
            prev = temp;
            temp = temp.next;
        }
        while (carry != 0) {
            prev.next = new ListNode(carry % 10);
            carry /= 10;
            prev = prev.next;
        }
        return rev(head);
    }

    ListNode rev(ListNode head) {
        ListNode curr = head, fwd = null, prev = null;
        while (curr != null) {
            fwd = curr.next;
            curr.next = prev;
            prev = curr;
            curr = fwd;
        }
        return prev;
    }
}
