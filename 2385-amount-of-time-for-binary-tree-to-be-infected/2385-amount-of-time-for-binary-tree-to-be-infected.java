class Solution {
HashMap<Integer, List<Integer>> graph;
    void createGraph(TreeNode root, int par) {
        if(root == null) return;
        if (par != -1) {
            List<Integer> temp = graph.getOrDefault(par, new ArrayList<>());
            temp.add(root.val);
            graph.put(par, temp);
            temp = graph.getOrDefault(root.val, new ArrayList<>());
            temp.add(par);
            graph.put(root.val, temp);
        }
        createGraph(root.left, root.val);
        createGraph(root.right, root.val);
    }

    public int amountOfTime(TreeNode root, int start) {
        graph = new HashMap<>();
       createGraph(root, -1);
        if(graph.size() == 0) return 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        HashSet<Integer> set = new HashSet<>();
        set.add(start);
        int time = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0;i<size;i++){
                int nodes = q.poll();
                List<Integer> adj = graph.get(nodes);
                for(int node: adj){
                    if(!set.contains(node)){
                        q.add(node);
                        set.add(node);
                    }
                }
            }
            if(q.size() != 0) time++;
        }
        return time;
    }
}
