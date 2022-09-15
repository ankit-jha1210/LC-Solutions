class Solution {

    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        if (n % 2 == 1) return new int[0];
        Arrays.sort(changed);
        List<Integer> res = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int change : changed) map.put(change, map.getOrDefault(change, 0) + 1);
        for (int change : changed) {
            if (map.get(change) == 0) continue;
            if (!map.containsKey(change * 2)) return new int[0];
            if (map.get(change * 2) == 0) return new int[0];
            map.put(change, map.get(change) - 1);
            map.put(2 * change, map.get(change * 2) - 1);
            res.add(change);
        }
        int[] ans = new int[n / 2];
        int i = 0;
        while (i < ans.length) {
            ans[i] = res.get(i++);
        }
        return ans;
    }
}
