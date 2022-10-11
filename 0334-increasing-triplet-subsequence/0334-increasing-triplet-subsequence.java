class Solution {

    public boolean increasingTriplet(int[] nums) {
        int prev = Integer.MAX_VALUE, prev2 = Integer.MAX_VALUE; 
        int len = 1;
        for (int i = 0; i < nums.length; i++) {
            if(prev >= nums[i]) prev = nums[i];
            else if(prev2 >= nums[i]) prev2 = nums[i];
            else return true;
            
        }
        return false;
    }
}
