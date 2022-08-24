class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b)->(a[1] - b[1]));
        int n = intervals.length;
        int res = 0;
        int prev = Integer.MIN_VALUE;
        for(int[] interval: intervals){
            if(interval[0] >= prev){
                prev = interval[1];
            }
            else{
                res++;
            }
        }
        return res;
    }
}
// 1,2
// 2,3
// 1,3
// 3,4