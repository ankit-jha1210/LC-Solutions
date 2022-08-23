class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode fast = head, slow = head;
        while(fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode temp = slow.next;
        slow.next = null;
        temp = reverse(temp);
        slow = head;
        while(temp !=null){
            if(slow.val != temp.val) return false;
            slow = slow.next;
            temp = temp.next;
        }
        return true;
    }
    ListNode reverse(ListNode head){
        ListNode curr = head, prev = null , fwd = null;
        while(curr != null){
            fwd = curr.next;
            curr.next = prev;
            prev = curr;
            curr = fwd;
        }
        return prev;
    }
}
// 1 2 3 4 5