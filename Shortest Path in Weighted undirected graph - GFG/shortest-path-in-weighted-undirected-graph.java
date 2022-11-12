//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
@SuppressWarnings("unchecked") class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int edges[][] = new int[m][3];
            for (int i = 0; i < m; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
                edges[i][2] = sc.nextInt();
            }
            Solution obj = new Solution();
            List<Integer> ans = obj.shortestPath(n, m, edges);
            for (int e : ans) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends
class Solution {
    public static List<Integer> shortestPath(int n, int m, int edges[][]) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++) adj.add(new ArrayList<>());
        for(int i = 0; i < m; i++) {
            adj.get(edges[i][0]).add(new Pair(edges[i][2], edges[i][1]));
            adj.get(edges[i][1]).add(new Pair(edges[i][2], edges[i][0]));
        }
        int[] dist = new int[n + 1];
        int[] par = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            par[i] = i;
            dist[i] = Integer.MAX_VALUE;
        }
        dist[1] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.first - b.first);
        pq.add(new Pair(0, 1));
        while(!pq.isEmpty()) {
            Pair nodes = pq.poll();
            int node = nodes.second;
            for(Pair p : adj.get(node)) {
                if(dist[node] + p.first < dist[p.second]) {
                    dist[p.second] = dist[node] + p.first;
                    par[p.second] = node;
                    pq.add(new Pair(dist[p.second], p.second));
                }
            }
            
        }
        List<Integer> path = new ArrayList<>();
        if(dist[n] == Integer.MAX_VALUE) {
            path.add(-1);
            return path;
        }
        int node = n;
        while(par[node] != node) {
            path.add(node);
            node = par[node];
        }
        path.add(1);
        Collections.reverse(path);
        return path;
    }
    
   static class Pair {
        int first;
        int second;
        public Pair(int first, int second) {
            this.second = second;
            this.first = first;
        }
    }
}