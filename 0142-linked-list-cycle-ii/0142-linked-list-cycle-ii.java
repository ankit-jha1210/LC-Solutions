public class Solution {
    
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head, entry = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow) {
                while(slow != entry) {
                    slow = slow.next;
                    entry = entry.next;
                }
                return entry;
            }
        }
        return null;
    }
}
