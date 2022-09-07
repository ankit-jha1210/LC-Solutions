class Solution {

    public String tree2str(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        solve(root, sb);
        return sb.toString();
    }

    public void solve(TreeNode root, StringBuilder sb) {
        if (root == null) return;
        sb.append(root.val);
        if(root.left == null && root.right == null) return;
        sb.append("(");
        if(root.left != null) solve(root.left, sb);
        sb.append(")");
        if(root.right != null) {
            sb.append("(");
            solve(root.right, sb);
            sb.append(")");
        }
    }
}
