class Solution {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
        HashMap<String, Boolean> map = new HashMap<>();
        for (String s : wordList) map.put(s, false);
        Queue<String> pendingNodes = new LinkedList<>();
        pendingNodes.add(beginWord);
        int level = 1;
        map.put(beginWord, true);
        while (!pendingNodes.isEmpty()) {
            int size = pendingNodes.size();
            for (int i = 0; i < size; i++) {
                String s = pendingNodes.poll();
                if (s.equals(endWord)) return level;
                wordMatch(s, map, pendingNodes);
            }
            level++;
        }
        return 0;
    }

    void wordMatch(String s, HashMap<String, Boolean> map, Queue<String> pendingNodes) {
        for (int i = 0; i < s.length(); i++) {
            char[] word = s.toCharArray();
            for (int j = 0; j < 26; j++) {
                word[i] = (char) ('a' + j);
                String newWord = String.valueOf(word);
                if (map.containsKey(newWord) && !map.get(newWord)) {
                    map.put(newWord, true);
                    pendingNodes.add(newWord);
                }
            }
        }
    }
}
