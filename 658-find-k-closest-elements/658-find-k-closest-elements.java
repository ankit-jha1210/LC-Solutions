class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int lo = 0 , hi = arr.length - 1;
        while(hi - lo + 1 > k) {
            int diff1 = Math.abs(arr[lo] - x);
            int diff2 = Math.abs(arr[hi] - x);
            if(diff1 > diff2) lo++;
            else hi--;
        }
        List<Integer> res = new ArrayList<Integer>();
        while(lo <= hi) {
            res.add(arr[lo++]);
        }
        return res;
    }
}