class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        for(int i = 0; i < color.length; i++) {
            if(color[i] == 0 &&  !solve(graph, i, 0, color)) return false;
        }
        return true;
    }
    boolean solve(int[][] graph, int node, int par_col, int[] color) {
        color[node] = par_col == 1 ? 2 : 1;
        for(int it: graph[node]) {
            if(color[it] == 0) {
                if(!solve(graph, it, color[node], color)) return false;
            }
            else if(color[it] == color[node]) return false;
        }
        return true;
    }
}