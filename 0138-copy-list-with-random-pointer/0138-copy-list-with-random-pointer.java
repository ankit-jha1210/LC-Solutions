class Solution {

    public Node copyRandomList(Node head) {
        if(head == null) return head;
        Node temp = head;
        while (temp != null) {
            Node clone = new Node(temp.val);
            clone.next = temp.next;
            temp.next = clone;
            temp = temp.next.next;
        }
        temp = head;
        while (temp != null) {
            if (temp.random != null) temp.next.random = temp.random.next;
            temp = temp.next.next;
        }
        Node cloneHead = new Node(0), cloneTail = cloneHead;
        temp = head;
        while (temp != null) {
            cloneTail.next = temp.next;
            cloneTail = cloneTail.next;
            temp.next = temp.next.next;
            temp = temp.next;
        }
        return cloneHead.next;
    }
}
