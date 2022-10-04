class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<HashMap<Character, Integer>, List<String>> map = new HashMap<>();
        for (String str : strs) {
            HashMap<Character, Integer> fMap = new HashMap<>();
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                fMap.put(ch, fMap.getOrDefault(ch, 0) + 1);
            }
            if(map.containsKey(fMap)) map.get(fMap).add(str);
            else {
                List<String> lst = new ArrayList<>();
                lst.add(str);
                map.put(fMap, lst);
            }
        }
        List<List<String>> res = new ArrayList<>();
        for(List<String> lst: map.values()) res.add(lst);
        return res;
    }
}
