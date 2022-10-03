class Solution {

    public int minCost(String colors, int[] neededTime) {
        int i = 0, res = 0;
        while (i < colors.length()) {
            int j = i + 1;
            int currTotal = neededTime[i], currMax = neededTime[i];
            while (j < colors.length() && colors.charAt(i) == colors.charAt(j)) {
                currTotal += neededTime[j];
                currMax = Math.max(currMax, neededTime[j]);
                j++;
            }
            res += (currTotal - currMax);
            i = j;
        }
        return res;
    }
}
