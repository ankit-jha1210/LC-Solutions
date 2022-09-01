class Solution {
    public int goodNodes(TreeNode root) {
        return solve(root, Integer.MIN_VALUE);
    }
    int solve(TreeNode root, int max) {
        if(root == null) return 0;
        if(root.val < max) {
            return solve(root.left, max) + solve(root.right, max);
        }
        else {
            return solve(root.left, root.val) + solve(root.right, root.val) + 1;
        }
    }
}