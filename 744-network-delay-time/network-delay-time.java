class Solution {

    public int networkDelayTime(int[][] times, int n, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int[] dist = new int[n + 1];
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());
        for (int i = 0; i < times.length; i++) {
            int u = times[i][0];
            int v = times[i][1];
            int time = times[i][2];
            graph.get(u).add(new int[] { v, time });
        }
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        pq.add(new int[] { 0, k });
        while (!pq.isEmpty()) {
            int[] nodes = pq.poll();
            int node = nodes[1];
            int time = nodes[0];
            for (int[] it : graph.get(node)) {
                if (time + it[1] < dist[it[0]]) {
                    dist[it[0]] = time + it[1];
                    pq.add(new int[] { dist[it[0]], it[0] });
                }
            }
        }
        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1;
            max = Math.max(max, dist[i]);
        }
        return max;
    }
}
