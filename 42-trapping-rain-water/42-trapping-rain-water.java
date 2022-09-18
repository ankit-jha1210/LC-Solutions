class Solution {

    public int trap(int[] height) {
        int n = height.length, ans = 0;
        int left = 0, right = n - 1;
        int leftMax = 0, rightMax = 0;
        while (left <= right) {
            if (height[left] <= height[right]) {
                // we come here which means something is greater in right than it
                // and how can we be sure that leftMax <= rightMax
                // well we move the left pointer only if it is <= height[right]
                // so there is someone on right greater than it and in question we require min
                if (height[left] >= leftMax) leftMax = height[left]; 
                else ans += leftMax - height[left];
                left++;
            } else {
                if (height[right] >= rightMax) rightMax = height[right]; else ans += rightMax - height[right];
                right--;
            }
        }
        return ans;
    }
}
