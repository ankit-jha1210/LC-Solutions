class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int pro = 1;
        int cnt = 0;
        for(int num: nums) {
            if(num != 0) pro *= num;
            else {
                cnt++;
                if(cnt > 1) return res;
            }
        }
        for(int i = 0; i < nums.length; i++) {
            if(cnt == 1) {
                if(nums[i] == 0) res[i] = pro;
            }
            else res[i] = pro/nums[i];
        }
        return res;
    }
}