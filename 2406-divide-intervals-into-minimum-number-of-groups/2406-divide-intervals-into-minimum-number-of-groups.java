class Solution {
    public int minGroups(int[][] intervals) {
        int[] prefix = new int[1000005];
        int n = intervals.length;
        for(int i = 0;i<n;i++) {
            prefix[intervals[i][0]]++;
            prefix[intervals[i][1]+1]--;
        }
        int sum = 0, res = 0;
        for(int i = 0;i<1000005;i++) {
            sum += prefix[i];
            res = Math.max(sum, res);
        }
        return res;
    }
}