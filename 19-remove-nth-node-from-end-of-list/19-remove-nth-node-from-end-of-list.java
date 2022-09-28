class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int total = 0;
        ListNode tmp = head;
        while (tmp != null) {
            tmp = tmp.next;
            total++;
        }
        System.out.println(total);
        int dist = total - n - 1;
        if(dist == -1) return head.next;
        tmp = head;
        while(tmp != null && dist != 0) {
            tmp = tmp.next;
            dist--;
        }
        tmp.next = tmp.next.next;
        return head;
    }
}
