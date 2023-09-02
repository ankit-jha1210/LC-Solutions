class Solution {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root);
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        while (!s1.isEmpty() || !s2.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            while (!s1.isEmpty()) {
                TreeNode node = s1.pop();
                temp.add(node.val);
                if (node.left != null) s2.push(node.left);
                if (node.right != null) s2.push(node.right);
            }
            res.add(temp);
            if(s2.isEmpty()) break;
            temp = new ArrayList<>();
            while (!s2.isEmpty()) {
                TreeNode node = s2.pop();
                temp.add(node.val);
                if (node.right != null) s1.push(node.right);
                if (node.left != null) s1.push(node.left);
            }
            res.add(temp);
        }
        return res;
    }
}
