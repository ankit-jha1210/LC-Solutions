class Solution {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0; 
        HashMap<String, Boolean> map = new HashMap<>();
        for(String str: wordList) map.put(str, false);
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        map.put(beginWord, true);
        int level = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String node = q.poll();
                if (node.equals(endWord)) return level;
                wordMatch(node, q, wordList, map);
            }
            level++;
        }
        return 0;
    }

    void wordMatch(String node, Queue<String> q, List<String> wordList, HashMap<String, Boolean> map) {
        for (int i = 0; i < node.length(); i++) {
            char[] ch = node.toCharArray();
            for (int j = 0; j < 26; j++) {
                ch[i] = (char)('a' + j);
                String str = String.valueOf(ch);
                if (map.containsKey(str) && !map.get(str)) {
                    map.put(str, true);
                    q.add(str);
                }
            }
        }
    }
}
