class Solution {

    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node temp = head;
        while (temp != null) {
            map.put(temp, new Node(temp.val));
            temp = temp.next;
        }
        temp = head;
        while (temp != null) {
            Node cloneTemp = map.get(temp);
            cloneTemp.next = map.get(temp.next);
            if (temp.random != null) cloneTemp.random = map.get(temp.random);
            temp = temp.next;
        }
        return map.get(head);
    }
}
