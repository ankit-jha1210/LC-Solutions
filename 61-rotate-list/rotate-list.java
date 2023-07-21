class Solution {

    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        ListNode tail = head;
        int size = 1;
        while (tail.next != null) {
            size++;
            tail = tail.next;
        }
        k = k % size;
        int pos = size - k;

        ListNode temp = head;
        for (int i = 1; i < pos; i++) temp = temp.next;
        tail.next = head;
        head = temp.next;
        temp.next = null;
        return head;
    }
}
