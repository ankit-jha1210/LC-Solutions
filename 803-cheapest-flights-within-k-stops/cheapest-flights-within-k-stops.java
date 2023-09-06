class Solution {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> graph = new ArrayList<>();
        int edges = flights.length;
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int i = 0; i < edges; i++) {
            int u = flights[i][0];
            int v = flights[i][1];
            graph.get(u).add(new Pair(v, flights[i][2]));
        }
        Queue<int[]> q = new LinkedList<>();
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        q.add(new int[] { src, 0, 0 });
        while (!q.isEmpty()) {
            int[] p = q.poll();
            int city = p[0];
            int stops = p[1];
            int cost = p[2];
            if (stops > k) continue;
            for (Pair it : graph.get(city)) {
                if (cost + it.second < dist[it.first]) {
                    dist[it.first] = cost + it.second;
                    q.add(new int[] { it.first, stops + 1, dist[it.first] });
                }
            }
        }

        return dist[dst] != Integer.MAX_VALUE ? dist[dst] : -1;
    }
}

class Pair {
    int first;
    int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
