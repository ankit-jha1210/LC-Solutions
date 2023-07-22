public class Solution {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int diff = diff(headA, headB);
        if (diff > 0) while (diff-- > 0) headA = headA.next; else while (diff++ < 0) headB = headB.next;

        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    int diff(ListNode h1, ListNode h2) {
        int len1 = 0, len2 = 0;
        while (h1 != null || h2 != null) {
            if (h1 != null) {
                h1 = h1.next;
                len1++;
            } else {
                h2 = h2.next;
                len2++;
            }
        }

        return len1 - len2;
    }
}
