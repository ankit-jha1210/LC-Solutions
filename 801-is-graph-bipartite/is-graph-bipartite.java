class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        for(int i = 0; i < n; i++) {
            if(color[i] == 0 && !solve(graph, i, 0, color)) return false;
        }
        return true;
    }

    boolean solve(int[][] graph, int node, int par, int[] color) {
        color[node] = color[par] == 1 ? 2 : 1;
        for(int vertex: graph[node]) {
            if(color[vertex] == 0) {
                if(!solve(graph, vertex, node, color)) return false;
            }
            else if(color[vertex] == color[node]) return false;
        }
        return true;
    }
}