class Solution {

    public boolean isValidBST(TreeNode root) {
        return solve(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    boolean solve(TreeNode root, long min, long max) {
        if (root == null) return true;

        if (root.val <= min || root.val >= max) return false;

        return solve(root.left, min, root.val) && solve(root.right, root.val, max);
    }
}
