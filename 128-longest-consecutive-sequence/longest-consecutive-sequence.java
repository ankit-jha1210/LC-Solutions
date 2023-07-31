class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num: nums) set.add(num);
        int len = 0;
        for(int num: set) {
            if(!set.contains(num - 1)) {
                int elm = num + 1;
                while(set.contains(elm)) elm++;
                len = Math.max(len, elm - num);
            }
        }
        return len;
    }
}