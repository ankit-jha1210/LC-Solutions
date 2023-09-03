class Solution {

    public TreeNode sortedArrayToBST(int[] nums) {
        return solve(nums, 0, nums.length - 1);
    }

    TreeNode solve(int[] nums, int start, int end) {
        if (start > end) return null;

        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = solve(nums, start, mid - 1);
        root.right = solve(nums, mid + 1, end);
        return root;
    }
}
