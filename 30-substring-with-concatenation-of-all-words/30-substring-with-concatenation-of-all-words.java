class Solution {

    public List<Integer> findSubstring(String s, String[] words) {
        HashMap<String, Integer> freq = new HashMap<>();
        for (String word : words) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }
        List<Integer> res = new ArrayList<>();
        int totalWords = words.length;
        int wordLength = words[0].length();
        for (int i = 0; i <= s.length() - totalWords * wordLength; i++) {
            HashMap<String, Integer> seenWords = new HashMap<>();
            int j = 0;
            for (; j < totalWords; j++) {
                int wordIndex = i + j * wordLength;
                String temp = s.substring(wordIndex, wordIndex + wordLength);
                if (!freq.containsKey(temp)) break;
                seenWords.put(temp, seenWords.getOrDefault(temp, 0) + 1);
                if (seenWords.get(temp) > freq.get(temp)) break;
            }
            if (j == totalWords) {
                res.add(i);
            }
        }
        return res;
    }
}
