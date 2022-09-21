class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int[] res = new int[queries.length];
        int sum = 0;
        for(int  num: nums) {
            if(num%2 == 0) sum += num;
        }
        for(int i = 0; i < queries.length; i++) {
            int idx = queries[i][1];
            int val = queries[i][0];
          int tmp  = nums[idx] + val;
            if(tmp % 2 == 0) {
                if(nums[idx] % 2 == 0) sum += val;
                else sum += tmp;
            }
            else {
                if(nums[idx] % 2 == 0) sum -= nums[idx];
            }
            nums[idx] = tmp;
            res[i] = sum;
        }
        return res;
    }
}