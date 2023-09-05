class Solution {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>();
        for (String s : wordList) set.add(s);
        if (!set.contains(endWord)) return 0;
        set.remove(beginWord);
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));
        while (!q.isEmpty()) {
            Pair p = q.poll();
            String str = p.first;
            int level = p.second;
            if (str.equals(endWord)) return level;
            char[] arr = str.toCharArray();
            for (char ch = 'a'; ch <= 'z'; ch++) {
                for (int i = 0; i < arr.length; i++) {
                    char temp = arr[i];
                    arr[i] = ch;
                    String newString = String.valueOf(arr);
                    if (set.contains(newString)) {
                        q.add(new Pair(newString, level + 1));
                        set.remove(newString);
                    }
                    arr[i] = temp;
                }
            }
        }
        return 0;
    }
}

class Pair {
    String first;
    int second;

    public Pair(String first, int second) {
        this.first = first;
        this.second = second;
    }
}
