class Solution {

    public int minimumIndex(List<Integer> nums) {
        int dominant = -1;
        int maxi = 0;
        int n = nums.size();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);
        for (int key : map.keySet()) {
            int value = map.get(key);
            if (value > maxi) {
                dominant = key;
                maxi = value;
            }
        }

        int cnt = 0;
        for(int i = 0; i < n; i++) {
            int num = nums.get(i);
            if(num == dominant) cnt++;
            int rightSide = maxi - cnt;
            if(2 * cnt > i + 1 && 2 * rightSide > n - i - 1) return i;
        }
        return -1;

        
    }
}