class Solution {

    public int minScore(int n, int[][] roads) {
        ArrayList<ArrayList<Pair>> adj = makeGraph(n, roads);
        Queue <Integer> q = new LinkedList<>();
        q.add(1);
        int ans = Integer.MAX_VALUE;
        boolean[] visited = new boolean[n +  1];  
        visited[1] = true;
        while (!q.isEmpty()) {
            int node = q.poll();
            for (Pair p : adj.get(node)) {
                ans = Math.min(ans, p.second);
                if (!visited[p.first]) {
                    q.add(p.first);
                    visited[p.first] = true;
                }
            }
        }
        return ans;
    }

    ArrayList<ArrayList<Pair>> makeGraph(int n, int[][] roads) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());
        for (int i = 0; i < roads.length; i++) {
            int u = roads[i][0];
            int v = roads[i][1];
            adj.get(u).add(new Pair(v, roads[i][2]));
            adj.get(v).add(new Pair(u, roads[i][2]));
        }

        return adj;
    }

    class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}
