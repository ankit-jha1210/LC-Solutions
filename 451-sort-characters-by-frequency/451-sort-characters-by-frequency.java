class Solution {

    public String frequencySort(String s) {
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) map.put(ch, map.getOrDefault(ch, 0) + 1);
        List<Character> buckets[] = new List[n + 1];
        map.forEach(
            (key, value) -> {
                if (buckets[value] == null) {
                    buckets[value] = new ArrayList<>();
                }
                buckets[value].add(key);
            }
        );
        StringBuilder sb = new StringBuilder();
        for (int i = n; i > 0; i--) {
            if (buckets[i] != null) {
                for (char c : buckets[i]) {
                    int j = 0;
                    while(j < i) {
                        sb.append(c);
                        j++;
                    }
                }
            }
        }
        return sb.toString();
    }
}
