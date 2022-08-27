class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int i;
        for(i = 0;i<intervals.length;i++){
            if(newInterval[0] > intervals[i][0]) res.add(intervals[i]);
            else break;
        }
        if(res.size() == 0 || res.get(res.size()-1)[1] < newInterval[0]){
            res.add(newInterval);
        }
        else{
            int[] lastInterval = res.get(res.size()-1);
            lastInterval[1] = Math.max(lastInterval[1], newInterval[1]);
        }
        while(i<intervals.length){
            int[] lastInterval = res.get(res.size()-1);
            if(lastInterval[1] < intervals[i][0]){
                res.add(intervals[i]);
            }
            else{
                lastInterval[1] = Math.max(lastInterval[1], intervals[i][1]);
            }
            i++;
        }
        return res.toArray(new int[res.size()][2]);
        
    }
}