class Solution {

    void dfs(List<List<Integer>> adj, int node, boolean[] visited) {
        visited[node] = true;
        for(Integer it: adj.get(node)) {
            if(!visited[it]) dfs(adj, it, visited);
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    adj.get(i).add(j);
                }
            }
        }
        int cnt = 0;
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                dfs(adj, i, visited);
                cnt++;
            }
        }
        return cnt;
    }
}
