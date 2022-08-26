// class Pair {
//     int listNo;
//     ListNode node;

//     Pair(int i, ListNode j) {
//         listNo = i;
//         node = j;
//     }
// }

class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        int k = lists.length;
        for (int i = 0; i < k; i++) {
            if (lists[i] != null) pq.add(lists[i]);
        }
        ListNode head = new ListNode(-1);
        ListNode tail = head;
        while (!pq.isEmpty()) {
            ListNode p = pq.poll();
            if (p.next != null) {
                pq.add(p.next);
            }
            tail.next = p;
            tail = tail.next;
        }
        return head.next;
    }
}
