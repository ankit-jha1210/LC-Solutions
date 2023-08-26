class Solution {

    public int maxJump(int[] stones) {
        int low = 0, high = stones[stones.length - 1];
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(stones, mid)) {
                ans = mid;
                high = mid - 1;
            } else low = mid + 1;
        }
        return ans;
    }

    boolean isPossible(int[] stones, int max) {
        int n = stones.length;
        boolean[] visited = new boolean[n];
        int i = 0;
        while (i < stones.length - 1) {
            int j = i + 1;
            while (j < n && stones[j] - stones[i] <= max) j++;
            if (i == j - 1 || stones[j - 1] - stones[i] > max) return false;
            visited[i] = true;
            System.out.println(max + " " + j);
            i = j - 1;
        }
        visited[0] = false;
        i = n - 1;
        while (i > 0) {
            int j = i - 1;
            while (j >= 0 &&  visited[j]) j--;
            if (j < 0 || stones[i] - stones[j] > max) return false;
            // System.out.println(max+" "+j);
            visited[j] = true;
            i = j;
        }
        return true;
    }
}
