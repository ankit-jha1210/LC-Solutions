/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {

    public List<Integer> preorder(Node root) {
        List<Integer> tmp = new ArrayList<>();
        solve(root, tmp);
        return tmp;
    }

    void solve(Node root, List<Integer> tmp) {
        if (root == null) return;
        tmp.add(root.val);
        // if (root.children != null) {
            for (Node child : root.children) {
                solve(child, tmp);
            }
        // }
    }
}
