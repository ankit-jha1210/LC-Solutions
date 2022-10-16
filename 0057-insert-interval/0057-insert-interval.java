class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> lst = new ArrayList<>();
        int idx = 0;
        while(idx < intervals.length) {
            if(intervals[idx][0] < newInterval[0]) {
                lst.add(intervals[idx++]);
            }
            else break;
        }
        if(lst.size() == 0 || lst.get(lst.size() - 1)[1] < newInterval[0]) {
             lst.add(newInterval);
        }
        else {
            int[] lastInterval = lst.get(lst.size() - 1);
            lastInterval[1] = Math.max(lastInterval[1], newInterval[1]);
        }
        while(idx < intervals.length) {
            int[] lastInterval = lst.get(lst.size() - 1);
            if(lastInterval[1] >= intervals[idx][0]) {
                lastInterval[1] = Math.max(lastInterval[1], intervals[idx][1]);
            }
            else lst.add(intervals[idx]);
            idx++;
        }
        return lst.toArray(new int[lst.size()][2]);
        
    }
}