class Solution {
    int j = 0;

    public int kthSmallest(TreeNode root, int k) {
        j = 0;
        return inorder(root, k);
    }

    int inorder(TreeNode root, int k) {
        if (root == null) return -1;

        int left = inorder(root.left, k);
        if (left != -1) return left;
        j++;

        if (j == k) return root.val;

        return inorder(root.right, k);
    }
}
