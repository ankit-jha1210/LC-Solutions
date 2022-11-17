//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
// Position this line where user code will be pasted.

class GFG {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            List<List<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                List<Integer> temp = new ArrayList<>();
                for (int j = 0; j < 3; j++) {
                    int x = sc.nextInt();
                    temp.add(x);
                }
                adj.add(temp);
            }

            Solution obj = new Solution();
            System.out.println(obj.countPaths(n, adj));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    static int countPaths(int n, List<List<Integer>> roads) {
        int mod = (int)Math.pow(10, 9) + 7;
        List<List<int[]>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for(int i = 0; i < roads.size(); i++) {
            graph.get(roads.get(i).get(0)).add(new int[]{roads.get(i).get(1),roads.get(i).get(2)});
            graph.get(roads.get(i).get(1)).add(new int[]{roads.get(i).get(0),roads.get(i).get(2)});
        }
        int[] distance = new int[n];
        int[] ways = new int[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        Arrays.fill(distance, mod);
        distance[0] = 0;
        pq.add(new int[]{0, 0});
        ways[0] = 1;
        while(!pq.isEmpty()) {
            int[] data = pq.poll();
            int node = data[1];
            int cost = data[0];
            for(int[] adj: graph.get(node)) {
                int adjNode = adj[0];
                int curr_cost = cost + adj[1];
                if(curr_cost < distance[adjNode]) {
                    distance[adjNode] = curr_cost;
                    ways[adjNode] = ways[node];
                    pq.add(new int[]{curr_cost, adjNode});
                }
                else if(curr_cost == distance[adjNode]) {
                    ways[adjNode] = (ways[node] + ways[adjNode]) % mod;
                }
            }
        }
        return ways[n - 1] % mod;
    }
}
