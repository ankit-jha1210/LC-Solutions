class Solution {

    public boolean increasingTriplet(int[] nums) {
        List<Integer> res = new ArrayList<>();
        res.add(nums[0]);
        int len = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > res.get(len - 1)) {
                len++;
                if (len == 3) return true;
                res.add(nums[i]);
            } else {
                int idx = ceil(res, nums[i]);
                res.set(idx, nums[i]);
            }
        }
        return len >= 3;
    }

    int ceil(List<Integer> res, int target) {
        int low = 0, high = res.size() - 1;
        while (low <= high) {
            int mid = low + (high - low)/2;
            if(res.get(mid) == target) return mid;
            else if(res.get(mid) < target) low = mid + 1;
            else high = mid - 1;
        }
        return low;
    }
}
