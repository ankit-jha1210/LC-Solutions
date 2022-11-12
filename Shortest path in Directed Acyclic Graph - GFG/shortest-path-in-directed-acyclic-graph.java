//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] edge = new int[m][3];
			for (int i = 0; i < m; i++) {
				edge[i][0] = sc.nextInt();
				edge[i][1] = sc.nextInt();
				edge[i][2] = sc.nextInt();
			}
			Solution obj = new Solution();
			int res[] = obj.shortestPath(n, m,edge);
			for (int i = 0; i < n; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java
class Solution {

	public int[] shortestPath(int N,int M, int[][] edges) {
	    List<List<Pair>> adj = new ArrayList<>();
	    for(int i = 0; i < N;i++) {
	        adj.add(new ArrayList<>());
	    }
	    // create graph
	    for(int i = 0; i < M; i++) {
	        adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
	       // adj.get(edges[i][1]).add(new Pair(edges[i][0], edges[i][2]));
	    }
		Stack<Integer> stk = new Stack<>();
		boolean[] visited = new boolean[N];
		// do toposort
		for(int i = 0; i < N; i++) {
		    if(!visited[i]) topoSort(i, visited, stk, adj);
		}
		int[] dist = new int[N];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[0] = 0;
		while(!stk.isEmpty()) {
		    int node = stk.pop();
		    if(dist[node] != Integer.MAX_VALUE) {
		        for(Pair p: adj.get(node)) {
		            int it = p.first;
		            int weight = p.second;
		            if(dist[node] + weight < dist[it]) {
		                dist[it] = dist[node] + weight;
		            }
		            
		        }
		        
		    }
		    
		}
		for(int i = 0; i < dist.length; i++) {
		    if(dist[i] == Integer.MAX_VALUE) dist[i] = -1;
		}
		return dist;
	}
	void topoSort(int node, boolean[] visited, Stack<Integer> stk, List<List<Pair>> adj) {
	    visited[node] = true;
	    for(Pair p: adj.get(node)) {
	        int it = p.first;
	        if(!visited[it]) topoSort(it, visited, stk, adj);
	    }
	    stk.push(node);
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