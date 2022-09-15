class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 0, j = 0;
        int maxLen = 0;
        while(j < fruits.length) {
            map.put(fruits[j], map.getOrDefault(fruits[j], 0) + 1);
            if(map.size() <= 2) {
                maxLen = Math.max(maxLen, j - i + 1);
                j++;
            }
            else {
                while(map.size() > 2) {
                    int occurence = map.get(fruits[i]) - 1;
                    if(occurence == 0) map.remove(fruits[i]);
                    else map.put(fruits[i], occurence);
                    i++;
                }
                j++;
            }
        }
        return maxLen;
    }
}