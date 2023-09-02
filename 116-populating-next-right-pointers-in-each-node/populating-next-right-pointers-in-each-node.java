class Solution {

    public Node connect(Node root) {
        if (root == null) return root;
        Node temp = root;
        while (root.left != null) {
            Node curr = root;
            while (true) {
                curr.left.next = curr.right;
                if (curr.next == null) break;
                if (curr.right != null) curr.right.next = curr.next.left;
                curr = curr.next;
            }
            root = root.left;
        }
        return temp;
    }
}
