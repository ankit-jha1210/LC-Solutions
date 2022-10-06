class Solution {

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode oHead = null, oTail = null;
        ListNode eHead = null, eTail = null;
        int i = 1;
        ListNode temp = head;
        while (temp != null) {
            if (i % 2 == 1) {
                if (oHead == null) {
                    oHead = temp;
                    oTail = temp;
                } else {
                    oTail.next = temp;
                    oTail = oTail.next;
                }
            } else {
                if (eHead == null) {
                    eHead = temp;
                    eTail = temp;
                } else {
                    eTail.next = temp;
                    eTail = eTail.next;
                }
            }
            temp = temp.next;
            i++;
        }
        if (eHead != null) {
            oTail.next = eHead;
            eTail.next = null;
        }
        return oHead;
    }
}
