class Solution {

    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(
            properties,
            (a, b) -> {
                if (a[0] == b[0]) return a[1] - b[1]; else return b[0] - a[0];
            }
            
        );
        int maxD = Integer.MIN_VALUE;
        int ans = 0;
        for(int i = 0;i<properties.length;i++) {
            if(properties[i][1] < maxD) ans++;
            maxD = Math.max(maxD, properties[i][1]);
        }
        return ans;
    }
}
