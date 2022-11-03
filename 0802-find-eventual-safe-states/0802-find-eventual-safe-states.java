class Solution {

    public List<Integer> eventualSafeNodes(int[][] graph) {
        boolean[] visited = new boolean[graph.length];
        boolean[] dfsVisited = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                dfs(graph, i, visited, dfsVisited);
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            if (!dfsVisited[i]) res.add(i);
        }
        return res;
    }

    boolean dfs(int[][] graph, int node, boolean[] visited, boolean[] dfsVisited) {
        visited[node] = dfsVisited[node] = true;
        for (int it : graph[node]) {
            if (!visited[it]) {
                if (dfs(graph, it, visited, dfsVisited)) return true;
            } else if (dfsVisited[it]) return true;
        }
        dfsVisited[node] = false;
        return false;
    }
}
