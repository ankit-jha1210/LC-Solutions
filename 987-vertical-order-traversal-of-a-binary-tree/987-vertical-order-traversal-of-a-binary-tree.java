class Solution {

    class Pair implements Comparable<Pair> {
        int col;
        int val;

        Pair(int col, int val) {
            this.col = col;
            this.val = val;
        }

        public int compareTo(Pair p1) {
            if(this.col == p1.col) return this.val - p1.val;
            else return this.col - p1.col;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, PriorityQueue<Pair>> map = new TreeMap<>();
        dfs(root, 0, 0, map);
        List<List<Integer>> lst = new ArrayList<List<Integer>>();
        map.forEach(
            (key, value) -> {
                List<Integer> tmp = new ArrayList<>();
                while (!value.isEmpty()) {
                    tmp.add(value.poll().val);
                }
                lst.add(tmp);
            }
        );
        return lst;
    }

    void dfs(TreeNode root, int row, int col, TreeMap<Integer, PriorityQueue<Pair>> map) {
        if (root == null) return;
        if (!map.containsKey(col)) {
            map.put(col, new PriorityQueue<>());
        }
        map.get(col).add(new Pair(row, root.val));
        dfs(root.left, row + 1, col - 1, map);
        dfs(root.right, row + 1, col + 1, map);
    }
}
