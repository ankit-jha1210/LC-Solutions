class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //  there should be no cycle present in the graph

        List<List<Integer>> graph = new ArrayList<>();
        int edges = prerequisites.length;
        for (int i = 0; i < numCourses; i++) graph.add(new ArrayList<>());
        for (int i = 0; i < edges; i++) {
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];
            graph.get(u).add(v);
        }
        return isCycle(graph, numCourses);
    }

    boolean isCycle(List<List<Integer>> graph, int v) {
        Queue<Integer> q = new LinkedList<>();
        int[] inorder = new int[v];
        for (int i = 0; i < v; i++) {
            for (Integer it : graph.get(i)) inorder[it]++;
        }
        for(int i = 0; i < v; i++) {
            if(inorder[i] == 0) q.add(i);
        }
        int cnt = 0;
        while(!q.isEmpty()) {
            int node = q.poll();
            cnt++;
            for(Integer it: graph.get(node)) {
                inorder[it]--;
                if(inorder[it] == 0) q.add(it);
            }
        }
        return cnt == v;
    }
}
