public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int diff = getDiff(headA, headB);
        ListNode temp1 = headA, temp2 = headB;
        if(diff > 0) while(diff-- != 0) temp1 = temp1.next;
        else  while(diff++ != 0) temp2 = temp2.next;
        while(temp1 != temp2) {
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return temp1;
    }
    int getDiff(ListNode headA, ListNode headB) {
        int len1 = 0, len2 = 0;
        while(headA != null || headB != null) {
            if(headA != null) {
                headA = headA.next;
                len1++;
            }
            if(headB != null) {
                headB = headB.next;
                len2++;
            }
        }
        return len1 - len2;
    }
}