class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int elm1 = 0, elm2 = 0, cnt1 = 0, cnt2 = 0;
        for(int num: nums) {
            if(elm1 == num) cnt1++;
            else if(elm2 == num) cnt2++;
            else if(cnt1 == 0) {
                elm1 = num;
                cnt1++;
            }
            else if(cnt2 == 0) {
                elm2 = num;
                cnt2++;
            }
            else {
                cnt1--;
                cnt2--;
            }
        }
        List<Integer> res = new ArrayList<>();
        cnt1 = cnt2 = 0;
        for(int num: nums) {
            if(num == elm1) cnt1++;
            else if(num == elm2) cnt2++;
        }
        if(cnt1 > n/3) res.add(elm1);
       if(cnt2 > n/3) res.add(elm2);
        return res;
    }
}