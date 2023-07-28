class Solution {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int x = target - num;
            if (map.containsKey(x)) {
                return new int[] {map.get(x), i};
            }
            map.put(num, i);
        }
        return new int[2];
    }
}
