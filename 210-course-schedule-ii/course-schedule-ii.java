class Solution {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        initialiseGraph(numCourses, prerequisites, graph);
        Queue<Integer> q = new LinkedList<>();
        int[] inorder = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            for (Integer it : graph.get(i)) inorder[it]++;
        }
        for (int i = 0; i < numCourses; i++) {
            if (inorder[i] == 0) q.add(i);
        }
        while (!q.isEmpty()) {
            int node = q.poll();
            res.add(node);
            for (Integer it : graph.get(node)) {
                inorder[it]--;
                if (inorder[it] == 0) q.add(it);
            }
        }
        if(res.size() != numCourses) return new int[0];
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }

    void initialiseGraph(int numCourses, int[][] prerequisites, List<List<Integer>> graph) {
        int edges = prerequisites.length;
        for (int i = 0; i < numCourses; i++) graph.add(new ArrayList<>());
        for (int i = 0; i < edges; i++) {
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];
            graph.get(v).add(u);
        }
    }
}
