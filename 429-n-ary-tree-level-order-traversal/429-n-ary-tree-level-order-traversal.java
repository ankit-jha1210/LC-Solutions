class Solution {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            List<Integer> lst = new ArrayList<>();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node frontNode = q.poll();
                lst.add(frontNode.val);
                for (Node child : frontNode.children) {
                    q.add(child);
                }
            }
            res.add(lst);
        }
        return res;
    }
}
