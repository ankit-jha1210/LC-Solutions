class Solution {

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }
        Queue<TreeNode> q = new LinkedList<>();
        int curr_Depth = 1;
        q.add(root);
        while (curr_Depth < depth - 1) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            curr_Depth++;
        }
        while (!q.isEmpty()) {
            TreeNode frontNode = q.poll();
            TreeNode node = new TreeNode(val);
            node.left = frontNode.left;
            frontNode.left = node;
            node = new TreeNode(val);
            node.right = frontNode.right;
            frontNode.right = node;
        }
        return root;
    }
}
