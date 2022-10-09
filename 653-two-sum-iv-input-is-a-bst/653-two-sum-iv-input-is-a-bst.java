class Solution {

    public boolean findTarget(TreeNode root, int k) {
        return findTarget(root, root, k);
    }

    boolean findTarget(TreeNode root, TreeNode curr, int k) {
        if (curr == null) return false;
        return find(root, curr, k - curr.val) || 
              findTarget(root, curr.left, k) || 
              findTarget(root, curr.right, k);
    }

    boolean find(TreeNode root, TreeNode curr, int k) {
        if (root == null) return false;
        if (root.val == k && root != curr) return true;
        if(root.val > k) return find(root.left, curr, k);
        else return find(root.right, curr, k);
    }
}
