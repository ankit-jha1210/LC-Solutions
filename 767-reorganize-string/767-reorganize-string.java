class Solution {

    public class Pair {
        int freq;
        char ch;

        Pair(int freq, char ch) {
            this.freq = freq;
            this.ch = ch;
        }
    }

    public String reorganizeString(String s) {
        int[] map = new int[26];
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i) - 'a']++;
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.freq - a.freq);
        for (int i = 0; i < 26; i++) {
            if (map[i] != 0) {
                pq.add(new Pair(map[i], (char) (i + 'a')));
            }
        }
        StringBuilder res = new StringBuilder();
        Pair block = pq.poll();
        res.append(block.ch);
        block.freq--;
        while (!pq.isEmpty()) {
            Pair temp = pq.poll();
            res.append(temp.ch);
            temp.freq--;
            if (block.freq > 0) {
                pq.add(block);
            }
            block = temp;
        }
        if (block.freq != 0) return "";
        return res.toString();
    }
}
