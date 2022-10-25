class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) return head;
        int len = 1;
        ListNode temp = head;
        while(temp.next != null) {
            temp = temp.next;
            len++;
        }
        temp.next = head;
        k %= len;
        int pos = len - k; 
        temp = head;
        for(int i = 1; i < pos; i++) temp = temp.next;
        ListNode newHead = temp.next;
        temp.next = null;
        head = newHead;
        return head;
    }
}