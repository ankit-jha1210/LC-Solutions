//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int edge=sc.nextInt();
            int[][] adj = new int[edge][3];
            for(int i=0;i<edge;i++){
                adj[i][0]=sc.nextInt();
                adj[i][1]=sc.nextInt();
                adj[i][2]=sc.nextInt();
            }
            int src=sc.nextInt();
            int dst=sc.nextInt();
            int k=sc.nextInt();
            Solution obj = new Solution();
            int res = obj.CheapestFLight(n,adj,src,dst,k);
            System.out.println(res);
        }
    }
}

// } Driver Code Ends


class Solution {
    
    public int CheapestFLight(int n,int flights[][],int src,int dst,int k) {
        List<List<int[]>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for(int i = 0; i < flights.length; i++) {
            graph.get(flights[i][0]).add(new int[]{flights[i][1], flights[i][2]});
        }
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, src, 0});
        while(!q.isEmpty()) {
            int[] data = q.poll();
            int cost = data[0];
            int node = data[1];
            int stop = data[2];
            if(stop > k) continue;
            for(int[] it: graph.get(node)) {
                int adjNode = it[0];
                int adjCost = it[1];
                if(cost + adjCost < dist[adjNode]) {
                    dist[adjNode] = cost + adjCost;
                    q.add(new int[]{dist[adjNode], adjNode,  stop + 1});
                }
            }
        }
        if(dist[dst] == Integer.MAX_VALUE) return -1;
        else return dist[dst];
    }
}