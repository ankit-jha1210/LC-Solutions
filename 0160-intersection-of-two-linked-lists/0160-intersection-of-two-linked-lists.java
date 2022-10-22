
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode d1 = headA, d2 = headB;
        while(d1 != d2) {
            d1 = d1 == null ? headA: d1.next;
            d2 = d2 == null ? headB: d2.next;
        }
        return d1;
    }
}