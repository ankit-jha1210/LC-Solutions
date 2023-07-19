class Solution {
    int maxi;
    public int maxPathSum(TreeNode root) {
        maxi = Integer.MIN_VALUE;
        maxPathDown(root);
        return maxi;
    }

    int maxPathDown(TreeNode root) {
        if(root == null) return 0;

        int left = Math.max(0, maxPathDown(root.left));
        int right = Math.max(0, maxPathDown(root.right));

        maxi = Math.max(maxi, left + right + root.val);
        return Math.max(left, right) + root.val;
    }
}