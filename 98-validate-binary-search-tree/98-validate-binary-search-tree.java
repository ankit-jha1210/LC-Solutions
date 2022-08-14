class Solution {

    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean helper(TreeNode root, long min, long max) {
        if (root == null) return true;
        if (root.val > min && root.val < max) {
            return helper(root.left, min, root.val) && helper(root.right, root.val, max);
        }
        return false;
    }
}
