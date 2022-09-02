class Solution {

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> pendingNodes = new LinkedList<>();
        pendingNodes.add(root);
        while (!pendingNodes.isEmpty()) {
            int size = pendingNodes.size();
            double sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode frontNode = pendingNodes.poll();
                sum += frontNode.val;
                if (frontNode.left != null) pendingNodes.add(frontNode.left);
                if (frontNode.right != null) pendingNodes.add(frontNode.right);
            }
            res.add(sum / size);
        }
        return res;
    }
}
