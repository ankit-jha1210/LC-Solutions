class Solution {

    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int[] res = new int[queries.length];
        int sum = 0;
        for (int num : nums) {
            if (num % 2 == 0) sum += num;
        }
        for (int i = 0; i < queries.length; i++) {
            int idx = queries[i][1];
            if (nums[idx] % 2 == 0) {
                sum -= nums[idx];
            }
            nums[idx] += queries[i][0];
            if (nums[idx] % 2 == 0) sum += nums[idx];
            res[i] = sum;
        }
        return res;
    }
}
