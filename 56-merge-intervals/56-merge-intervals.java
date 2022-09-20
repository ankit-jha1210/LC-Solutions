class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> tmp = new ArrayList<>();
        int start = intervals[0][0], end = intervals[0][1];
        for(int i = 1;i<intervals.length;i++) {
           if(intervals[i][0] <= end) {
               end = Math.max(end, intervals[i][1]);
           }
            else{
                tmp.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        tmp.add(new int[]{start, end});
        int[][] res = new int[tmp.size()][2];
        int i = 0;
        for(int[] in: tmp) {
            res[i][0] = in[0];
            res[i++][1] = in[1];
        }
        return res;
    }
}