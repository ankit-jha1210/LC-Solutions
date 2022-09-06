class Pair {
    boolean hasOne;
    TreeNode node;
    Pair(boolean hasOne, TreeNode node) {
        this.hasOne = hasOne;
        this.node = node;
    }
}
class Solution {
    public TreeNode pruneTree(TreeNode root) {
        return solve(root).node;
        
    }
    public Pair solve(TreeNode root) {
        if(root == null) {
            return new Pair(false, null);
        }
        Pair left = solve(root.left);
        Pair right = solve(root.right);
        if(!left.hasOne && !right.hasOne && root.val != 1) return new Pair(false, null);
        root.left = left.node;
        root.right = right.node;
        return new Pair(true,root);
    }
}