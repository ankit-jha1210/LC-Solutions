//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();

            List<List<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();

                adj.get(u).add(v);
            }

            Solution obj = new Solution();
            List<Integer> safeNodes = obj.eventualSafeNodes(V, adj);
            for (int i : safeNodes) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    List<Integer> eventualSafeNodes(int V, List<List<Integer>> graph) {

       boolean[] visited = new boolean[V];
        boolean[] dfsVisited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(graph, i, visited, dfsVisited);
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (!dfsVisited[i]) res.add(i);
        }
        return res;
    }
     boolean dfs(List<List<Integer>> graph, int node, boolean[] visited, boolean[] dfsVisited) {
        visited[node] = dfsVisited[node] = true;
        for (int it : graph.get(node)) {
            if (!visited[it]) {
                if (dfs(graph, it, visited, dfsVisited)) return true;
            } else if (dfsVisited[it]) return true;
        }
        dfsVisited[node] = false;
        return false;
    }
}
