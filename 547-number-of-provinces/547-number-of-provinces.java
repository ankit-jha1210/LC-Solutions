class Solution {

    void dfs(List<List<Integer>> adj, boolean[] visited, int node) {
        visited[node] = true;
        for (Integer it : adj.get(node)) {
            if (!visited[it]) dfs(adj, visited, it);
        }
    }

    public int findCircleNum(int[][] isConnected) {
        List<List<Integer>> adj = new ArrayList<>();
        int n = isConnected.length;
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        //Constructing graph
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && isConnected[i][j] == 1) {
                    adj.get(i).add(j);
                }
            }
        }
        boolean[] visited = new boolean[n];
        int province = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(adj, visited, i);
                province++;
            }
        }
        return province;
    }
}
