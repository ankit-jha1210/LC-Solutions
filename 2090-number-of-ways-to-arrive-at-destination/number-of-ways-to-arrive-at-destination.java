class Solution {

    public int countPaths(int n, int[][] edges) {
        int m = edges.length;
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        int mod = (int) (1e9 + 7);
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(new int[] { v, edges[i][2] });
            adj.get(v).add(new int[] { u, edges[i][2] });
        }
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((a, b) -> Long.compare(a.second, b.second));
        long[] distance = new long[n];
        int[] ways = new int[n];
        Arrays.fill(distance, Long.MAX_VALUE);
        distance[0] = 0;
        ways[0] = 1;
        pq.add(new Pair(0, 0));
        while (!pq.isEmpty()) {
            Pair nodes = pq.poll();
            int node = nodes.first;
            long dist = nodes.second;
            for (int[] it : adj.get(node)) {
                if (dist + it[1] < distance[it[0]]) {
                    distance[it[0]] = dist + it[1];
                    ways[it[0]] = ways[node];
                    pq.add(new Pair(it[0], distance[it[0]]));
                } 
                else if (dist + it[1] == distance[it[0]]) ways[it[0]] = (ways[it[0]] + ways[node]) % mod;
            }
        }

        return ways[n - 1];
    }
}

class Pair {
    int first;
    long second;

    public Pair(int first, long second) {
        this.first = first;
        this.second = second;
    }
}
