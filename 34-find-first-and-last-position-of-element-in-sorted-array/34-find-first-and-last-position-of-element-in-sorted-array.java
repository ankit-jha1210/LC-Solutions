class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1,-1};
      ans[0] = findIndex(nums,target,true);
        if(ans[0]==-1) return ans;
      ans[1] = findIndex(nums,target,false);
        return ans;
    }
    int findIndex(int[] nums,int target,boolean findFirstIndex){
        int n = nums.length;
        int low = 0 , high = n-1;
        int ans = -1;
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid]<target) low = mid+1;
            else if(nums[mid]>target)high = mid-1;
            else{
                 ans = mid;
                if(findFirstIndex){
                    high = mid-1;
                }
                else low = mid+1;
            }
        }
        return ans;
    }
    
}