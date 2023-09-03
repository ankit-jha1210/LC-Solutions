class Solution {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return solve(inorder, postorder, 0, inorder.length - 1, 0, inorder.length);
    }

    TreeNode solve(int[] inorder, int[] postorder, int ps, int pe, int is, int ie) {
        if (ps > pe) return null;

        TreeNode root = new TreeNode(postorder[pe]);

        int idx = -1;
        for (int i = is; i <= ie; i++) {
            if (inorder[i] == postorder[pe]) {
                idx = i;
                break;
            }
        }
        if (idx == -1) return root;

        int lis = is;
        int lie = idx - 1;
        int lps = ps;
        int lpe = lie - lis + ps;
        int ris = idx + 1;
        int rie = ie;
        int rps = lpe + 1;
        int rpe = pe - 1;

        root.left = solve(inorder, postorder, lps, lpe, lis, lie);
        root.right = solve(inorder, postorder, rps, rpe, ris, rie);
        return root;
    }
}
