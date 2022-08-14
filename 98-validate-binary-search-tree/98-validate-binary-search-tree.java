class Solution {

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        long min = getMinMax(root.right, true);
        long max = getMinMax(root.left, false);
        if (root.val <= max || root.val >= min) return false;
        return isValidBST(root.left) && isValidBST(root.right);
    }

    public long getMinMax(TreeNode root, boolean isMin) {
        if (root == null) return isMin ? Long.MAX_VALUE : Long.MIN_VALUE;
        long left = getMinMax(root.left, isMin);
        long right = getMinMax(root.right, isMin);
        if (isMin) return Math.min(root.val, Math.min(left, right)); 
        else return Math.max(root.val, Math.max(left, right));
    }
}
