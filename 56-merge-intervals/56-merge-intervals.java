class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> tmp = new ArrayList<>();
        for(int i = 0;i<intervals.length;i++) {
            int start = intervals[i][0], end = intervals[i][1];
            if(!tmp.isEmpty() && tmp.get(tmp.size()-1)[1] >= start) continue;
            for(int j = i+1;j<intervals.length;j++) {
                if(intervals[j][0] <= end) end = Math.max(end, intervals[j][1]);
            }
            tmp.add(new int[]{start, end});
        }
        int[][] res = new int[tmp.size()][2];
        int i = 0;
        for(int[] in: tmp) {
            res[i][0] = in[0];
            res[i++][1] = in[1];
        }
        return res;
    }
}