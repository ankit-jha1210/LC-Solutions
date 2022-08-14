class Solution {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
        HashMap<String, Boolean> map = new HashMap<>();
        for (String s : wordList) map.put(s, false);
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        map.put(beginWord, true);
        int level = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String s = q.poll();
                if (s.equals(endWord)) return level;
                wordMatch(s, map, q);
            }
            level++;
        }
        return 0;
    }

    void wordMatch(String s, HashMap<String, Boolean> map, Queue<String> q) {
        for (int i = 0; i < s.length(); i++) {
            char[] word = s.toCharArray();
            for (int j = 0; j < 26; j++) {
                word[i] = (char) ('a' + j);
                String newWord = String.valueOf(word);
                if (map.containsKey(newWord) && !map.get(newWord)) {
                    map.put(newWord, true);
                    q.add(newWord);
                }
            }
        }
    }
}
