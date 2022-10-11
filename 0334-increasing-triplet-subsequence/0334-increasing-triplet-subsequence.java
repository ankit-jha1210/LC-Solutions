class Solution {

    public boolean increasingTriplet(int[] nums) {
        int prev = Integer.MAX_VALUE, prev2 = Integer.MAX_VALUE; 
        for (int num: nums) {
            if(prev >= num) prev = num;
            else if(prev2 >= num) prev2 = num;
            else return true;
            
        }
        return false;
    }
}
