class BSTIterator {
    Stack<TreeNode> stk;
    public BSTIterator(TreeNode root) {
        stk = new Stack<>();
        addNodes(root);
    }
    
    public int next() {
        TreeNode node = stk.pop();
        addNodes(node.right);
        return node.val;
    }
    
    public boolean hasNext() {
        return !stk.isEmpty();
    }

    void addNodes(TreeNode root) {
        while(root != null) {
            stk.push(root);
            root = root.left;
        }
    }
}