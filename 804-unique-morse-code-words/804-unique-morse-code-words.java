class Solution {
    String[] mapping = {
        ".-",
        "-...",
        "-.-.",
        "-..",
        ".",
        "..-.",
        "--.",
        "....",
        "..",
        ".---",
        "-.-",
        ".-..",
        "--",
        "-.",
        "---",
        ".--.",
        "--.-",
        ".-.",
        "...",
        "-",
        "..-",
        "...-",
        ".--",
        "-..-",
        "-.--",
        "--.."
    };

    public int uniqueMorseRepresentations(String[] words) {
        HashSet<String> set = new HashSet<>();
        for (String word : words) {
            String s = "";
            for (int i = 0; i < word.length(); i++) {
                int idx = word.charAt(i) - 'a';
                s += mapping[idx];
            }
            set.add(s);
        }
        return set.size();
    }
}
