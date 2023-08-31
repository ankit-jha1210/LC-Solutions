class Solution {

    public int maxStarSum(int[] vals, int[][] edges, int k) {
        ArrayList<ArrayList<Integer>> graph = makeGraph(vals.length, edges);
        boolean[] visited = new boolean[vals.length];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < vals.length; i++) {
            if (!visited[i]) max = Math.max(max, dfs(graph, i, k, visited, vals));
        }
        return max;
    }

    int dfs(ArrayList<ArrayList<Integer>> graph, int node, int k, boolean[] visited, int[] vals) {
        visited[node] = true;
        int res = Integer.MIN_VALUE;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (Integer it : graph.get(node)) {
            if (vals[it] > 0) pq.add(vals[it]);
            if (!visited[it]) res = Math.max(res, dfs(graph, it, k, visited, vals));
        }
        int sum = vals[node];
        while (k > 0 && !pq.isEmpty()) {
            sum += pq.poll();
            k--;
        }
        return Math.max(res, sum);
    }

    ArrayList<ArrayList<Integer>> makeGraph(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        return adj;
    }
}
