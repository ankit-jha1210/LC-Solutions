class Solution {

    public List<String> commonChars(String[] words) {
        List<String> lst = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        String word = words[0];
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (int i = 1; i < words.length; i++) {
            word = words[i];
            HashMap<Character, Integer> temp = new HashMap<>();
            for (Character ch : word.toCharArray()) {
                temp.put(ch, temp.getOrDefault(ch, 0) + 1);
            }
            for(char key: map.keySet()) {
                if(temp.containsKey(key)) {
                    map.put(key, Math.min(map.get(key), temp.get(key)));
                }
                else map.put(key, 0);
            }
        }
        for(char key: map.keySet()) {
            int n = map.get(key);
            for(int i = 0; i < n; i++) lst.add(key+"");
        }
        return lst;
    }
}
