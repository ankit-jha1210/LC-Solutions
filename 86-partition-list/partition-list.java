class Solution {

    public ListNode partition(ListNode head, int x) {
        ListNode smallHead = new ListNode(0), bigHead = new ListNode(0);
        ListNode smallTail = smallHead, bigTail = bigHead;

        while (head != null) {
            if (head.val < x) {
                smallTail.next = head;
                smallTail = smallTail.next;
            } else {
                bigTail.next = head;
                bigTail = bigTail.next;
            }
            head = head.next;
        }
        bigTail.next = null;
        smallTail.next = bigHead.next;
        return smallHead.next;
    }
}
