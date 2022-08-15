class Solution {

    public List<Integer> findSubstring(String s, String[] words) {
        HashMap<String, Integer> freq = new HashMap<>();
        for (String word : words) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
            // add all the frequency in the map
        }
        List<Integer> res = new ArrayList<>();
        int totalWords = words.length;
        int wordLength = words[0].length();
        for (int i = 0; i <= s.length() - totalWords * wordLength; i++) {
            // run loop until the valid index
            HashMap<String, Integer> seenWords = new HashMap<>();
            // we are taking another map so that no winfow can exceed the freq of a string
            int j = 0;
            for (; j < totalWords; j++) {
                int wordIndex = i + j * wordLength;
                String temp = s.substring(wordIndex, wordIndex + wordLength);
                if (!freq.containsKey(temp)) break;
                seenWords.put(temp, seenWords.getOrDefault(temp, 0) + 1);
                if (seenWords.get(temp) > freq.get(temp)) break; 
                // freq of temp in current window more than the freq in words[]
            }
            if (j == totalWords) {
                // if we were able to make a possible window of total words and each word of
                // word length than add in answer
                res.add(i);
            }
        }
        return res;
    }
}
