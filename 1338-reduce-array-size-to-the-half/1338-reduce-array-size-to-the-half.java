class Solution {

    public int minSetSize(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : arr) map.put(num, map.getOrDefault(num, 0) + 1);
        int[] freq = new int[map.size()];
        int i = 0;
        for (Integer val : map.values()) freq[i++] = val;
        Arrays.sort(freq);
         i = freq.length - 1;
        int removed = 0, half = arr.length / 2;
        int ans = 0;
        while (removed < half) {
            ans++;
            removed += freq[i--];
        }
        return ans;
    }
}
