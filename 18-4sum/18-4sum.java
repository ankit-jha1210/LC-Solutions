class Solution {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        long average_value = target / 4;
        int n = nums.length;
        if (average_value < nums[0] || average_value > nums[n - 1]) return res;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int start = j + 1, end = n - 1;
                while (start < end) {
                    long sum = nums[i] + nums[j] + nums[start] + nums[end];
                    if (sum == target) {
                        List<Integer> ans = new ArrayList<>();
                        ans.add(nums[i]);
                        ans.add(nums[j]);
                        ans.add(nums[start]);
                        ans.add(nums[end]);
                        res.add(ans);
                        while (start + 1 < n && nums[start] == nums[start + 1]) start++;
                        while (end - 1 >= 0 && nums[end] == nums[end - 1]) end--;
                        start++;
                        end--;
                    } else if (sum < target) start++; else end--;
                }
                while (j + 1 < n && nums[j] == nums[j + 1]) j++;
            }
            while (i + 1 < n && nums[i] == nums[i + 1]) i++;
        }
        return res;
    }
}
