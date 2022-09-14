class Solution {

    public int pseudoPalindromicPaths(TreeNode root) {
        return helper(root, 0);
    }

    int helper(TreeNode root, int path) {
        if (root == null) return 0;
        path = path ^ (1 << root.val);
        if (root.left == null && root.right == null) {
            if ((path & path - 1) == 0) return 1;
            return 0;
        }
        return helper(root.left, path) + helper(root.right, path);
    }
}
