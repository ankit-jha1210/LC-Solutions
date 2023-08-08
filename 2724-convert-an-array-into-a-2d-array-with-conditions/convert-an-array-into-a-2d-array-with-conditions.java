class Solution {

    public List<List<Integer>> findMatrix(int[] nums) {
        int[] cnt = new int[201];
        int rows = 1;
        for (int num : nums) {
            cnt[num]++;
            rows = Math.max(rows, cnt[num]);
        }
        List<List<Integer>> res = new ArrayList<>(rows);
        for (int i = 0; i < rows; i++) res.add(new ArrayList<>());
        for (int i = 1; i < 201; i++) {
            for (int j = 0; j < cnt[i]; j++) {
                res.get(j).add(i);
            }
        }
        return res;
    }
}
