class Solution {
    public Node copyRandomList(Node head) {
        Node temp = head;
        while(temp != null) {
            Node newNode = new Node(temp.val);
            newNode.next = temp.next;
            temp.next = newNode;
            temp = temp.next.next;
        }
        temp = head;
        while(temp != null) {
            if(temp.random != null) {
                temp.next.random = temp.random.next;
            }
            temp = temp.next.next;
        }
        Node dummy = new Node(0), tail = dummy;
        temp = head;
        while(temp != null) {
            tail.next = temp.next;
            tail = tail.next;
            temp.next = temp.next.next;
            temp = temp.next;
        }
        return dummy.next;
    }
}