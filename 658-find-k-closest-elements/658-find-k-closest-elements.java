class Solution {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int lo = 0, hi = arr.length - 1;
        while (hi - lo >= k) {
            if (arr[hi] - x >= x - arr[lo]) hi--; 
            else lo++;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = lo; i <= hi; i++) {
            res.add(arr[i]);
        }
        return res;
    }
}
