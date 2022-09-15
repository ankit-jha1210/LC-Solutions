class Solution {
    class Pair implements Comparable<Pair> {
        int first;
        char second;
        public Pair(int first, char second) {
            this.first = first;
            this.second = second;
        }
        public int compareTo(Pair p1) {
            return p1.first - this.first;
        }
    } 
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(char ch: s.toCharArray()) map.put(ch, map.getOrDefault(ch, 0) + 1);
        map.forEach((key, value) -> {
            pq.add(new Pair(value, key));
        });
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
            Pair p = pq.poll();
            for(int i = 0;i<p.first;i++) sb.append(p.second);
        }
        return sb.toString();
    }
}