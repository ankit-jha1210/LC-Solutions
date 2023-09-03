class Solution {
    public int minimumOperations(String num) {
        int ans = num.length();
        for(int i = num.length() - 1; i >= 0; i--) {
            for(int j = i - 1; j >= 0; j--) {
                int n = (num.charAt(i) - '0') + (num.charAt(j) - '0') * 10;
                if(n % 25 == 0) ans = Math.min(ans, num.length() - j - 2);
            }
            if(num.charAt(i) == '0') ans = Math.min(ans, num.length() - 1);
        }
        return ans;
    }
}