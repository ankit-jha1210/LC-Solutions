class Solution {

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        traverse(map, root, 0, 0);
        List<List<Integer>> res = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> ys : map.values()) {
            List<Integer> lst = new ArrayList<>();
            for (PriorityQueue<Integer> pq : ys.values()) {
                while (!pq.isEmpty()) {
                    int node = pq.poll();
                    lst.add(node);
                }
            }
            res.add(lst);
        }
        return res;
    }

    void traverse(TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map, TreeNode root, int vertical, int level) {
        if (root == null) return;

        if (!map.containsKey(vertical)) map.put(vertical, new TreeMap<>());
        if (!map.get(vertical).containsKey(level)) {
            map.get(vertical).put(level, new PriorityQueue<>());
        }
        map.get(vertical).get(level).offer(root.val);
        traverse(map, root.left, vertical - 1, level + 1);
        traverse(map, root.right, vertical + 1, level + 1);
    }
}
