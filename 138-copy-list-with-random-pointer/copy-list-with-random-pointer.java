class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node temp = head;
        while(head != null) {
            map.put(head, new Node(head.val));
            head = head.next;
        }
        for(Node node: map.keySet()) {
            Node copy = map.get(node);
            if(node.next != null) copy.next = map.get(node.next);
            if(node.random != null) copy.random = map.get(node.random);
        }
        return map.get(temp);
    }
}