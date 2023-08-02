class Solution {

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int l : nums4) {
            for (int k : nums3) map.put(l + k, map.getOrDefault(l + k, 0) + 1);
        }
        int cnt = 0;
        for (int i : nums1) {
            for (int j : nums2) {
                int sum = -(i + j);
                cnt += map.getOrDefault(sum, 0);
            }
        }
        return cnt;
    }
}
