class Solution {

    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stk = new Stack<>();
        List<Integer> lst = new ArrayList<>();
        TreeNode node = root;
        while (true) {
            if (node != null) {
                stk.push(node);
                node = node.left;
            } else {
                if (stk.isEmpty()) break;
                node = stk.pop();
                lst.add(node.val);
                node = node.right;
            }
        }
        return lst;
    }
}
