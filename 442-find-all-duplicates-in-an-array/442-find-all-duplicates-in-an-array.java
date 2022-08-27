class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer> ans = new ArrayList<>();
        map.forEach((key, value) ->{
            if(value>1) ans.add(key);
        });
        return ans;
    }
}