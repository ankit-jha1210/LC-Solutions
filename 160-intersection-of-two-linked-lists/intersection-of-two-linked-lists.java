public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        while(headA != null) {
            ListNode temp = headB;
            while(temp != null) {
                if(temp == headA) return temp;
                temp = temp.next;
            }
            headA = headA.next;
        }
        return null;
    }
}