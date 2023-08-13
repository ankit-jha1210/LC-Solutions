class Solution {

    public int maxSum(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxi = -1;
        for (int num : nums) {
            int digit = findMax(num);
            if (!map.containsKey(digit)) map.put(digit, num); 
            else {
                int sum = num + map.get(digit);
                maxi = Math.max(sum, maxi);
                map.put(digit, Math.max(map.get(digit), num));
            }
        }
        return maxi;
    }

    int findMax(int num) {
        int max = 0;
        while (num > 0) {
            max = Math.max(num % 10, max);
            num /= 10;
        }
        return max;
    }
}
