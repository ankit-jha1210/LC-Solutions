class Solution {

    class Pair {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        ArrayList<Pair> arr = new ArrayList<>();
        for (int[] num : intervals) {
            arr.add(new Pair(num[0], num[1]));
        }
        arr.add(new Pair(newInterval[0], newInterval[1]));
        Collections.sort(arr, (a, b) -> a.first - b.first);
        ArrayList<Pair> ans = new ArrayList<>();
        int start = arr.get(0).first;
        int end = arr.get(0).second;
        for (int i = 0; i <= n; i++) {
            if (end >= arr.get(i).first) {
                end = Math.max(end, arr.get(i).second);
            } else {
                ans.add(new Pair(start, end));
                start = arr.get(i).first;
                end = arr.get(i).second;
            }
        }
        ans.add(new Pair(start, end));
        int i = 0;
        int[][] res = new int[ans.size()][2];
        for (Pair p : ans) {
            res[i][0] = p.first;
            res[i++][1] = p.second;
        }
        return res;
    }
}
