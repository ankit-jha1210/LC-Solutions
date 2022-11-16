//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String[] S = read.readLine().split(" ");
            int N = Integer.parseInt(S[0]);
            int M = Integer.parseInt(S[1]);
            int Grid[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String[] s = read.readLine().split(" ");
                for (int j = 0; j < M; j++) Grid[i][j] = Integer.parseInt(s[j]);
            }
            Solution ob = new Solution();
            System.out.println(ob.MinimumEffort(Grid));
        }
    }
}
// } Driver Code Ends


class Solution {
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0 , 0, 1, -1};
    int MinimumEffort(int heights[][]) {
        int m = heights.length , n = heights[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[]{0, 0, 0});
        int[][] dist = new int[m][n];
        for(int[] row: dist) Arrays.fill(row, Integer.MAX_VALUE);
        dist[0][0] = 0;
        while(!pq.isEmpty()) {
            int[] nodes = pq.poll();
            int x = nodes[1], y = nodes[2];
            if(x == m - 1 && y == n -1) return nodes[0];
            for(int i = 0; i < 4; i++) {
                int newX = dx[i] + x;
                int newY = dy[i] + y;
                if(newX < 0 || newY < 0 || newX == m || newY == n) continue;
                int diff = Math.max(dist[x][y], Math.abs(heights[x][y] - heights[newX][newY]));
                if(diff < dist[newX][newY]) {
                    dist[newX][newY] = diff;
                    pq.add(new int[]{diff, newX, newY});
                }
            }
        }
        return -1;
    }
}