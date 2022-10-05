class Solution {

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1) {
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }
        insert(root, val, depth, 1);
        return root;
    }
    void insert(TreeNode root, int val, int d, int curr_Depth) {
        if(root == null) return;
        if(d - 1 == curr_Depth) {
            TreeNode node = new TreeNode(val);
            node.left = root.left;
            root.left = node;
            node = new TreeNode(val);
            node.right = root.right;
            root.right = node;
            return;
        }
        insert(root.left, val, d, curr_Depth + 1);
        insert(root.right, val, d, curr_Depth + 1);
    }
}
