class Solution {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] hash = new int[n];
        Arrays.sort(nums);
        dp[0] = 1;
        hash[0] = 0;
        int lastIndex = 0, maxi = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            hash[i] = i;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    hash[i] = j;
                }
            }

            if (dp[i] > maxi) {
                maxi = dp[i];
                lastIndex = i;
            }
        }
        List<Integer> lst = new ArrayList<Integer>();
        while (hash[lastIndex] != lastIndex) {
            lst.add(nums[lastIndex]);
            lastIndex = hash[lastIndex];
        }
        lst.add(nums[lastIndex]);
        return lst;
    }
}
