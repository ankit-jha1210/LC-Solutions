class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int lo = 0, hi = arr.length - 1;
        while(hi - lo + 1 > k) {
            if(Math.abs(arr[hi] - x) < Math.abs(arr[lo] - x)) lo++;
            else hi--;
        }

        List<Integer> res = new ArrayList<>();
        for(int i = lo; i <= hi; i++) res.add(arr[i]);
        return res;
    }
}