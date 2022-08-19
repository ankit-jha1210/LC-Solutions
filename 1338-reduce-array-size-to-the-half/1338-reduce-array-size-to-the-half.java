class Solution {

    public int minSetSize(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : arr) map.put(num, map.getOrDefault(num, 0) + 1);
        int n = arr.length;
        int[] freq = new int[n + 1];
        for (Integer val : map.values()) freq[val]++;
        int removed = 0, res = 0, half = n / 2;
        for (int i = n; i >= 0; i--) {
            while (freq[i] != 0 && removed < half) {
                removed += i;
                freq[i]--;
                res++;
            }
            if (removed >= half) break;
        }
        return res;
    }
}
