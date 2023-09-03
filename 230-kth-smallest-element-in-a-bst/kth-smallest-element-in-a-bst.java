class Solution {
    int cnt, elm;

    public int kthSmallest(TreeNode root, int k) {
        cnt = 0;
        elm = -1;
        inorder(root, k);
        return elm;
    }

    boolean inorder(TreeNode root, int k) {
        if (root == null) return false;

        if (inorder(root.left, k)) return true;

        cnt++;
        if (cnt == k) {
            elm = root.val;
            return true;
        }

        return inorder(root.right, k);
    }
}
