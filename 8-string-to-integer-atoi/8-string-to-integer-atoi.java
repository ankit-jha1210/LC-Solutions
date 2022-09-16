class Solution {

    public int myAtoi(String s) {
        int i = 0;
        int sign = 1;
        int no = 0;
        // eliminate white spaces
        while (i < s.length() && s.charAt(i) == ' ') i++;
        if (i < s.length() && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
            sign = s.charAt(i) == '-' ? -1 : 1;
            i++;
        }
        while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            if (no > Integer.MAX_VALUE / 10 || (no == Integer.MAX_VALUE/10 && s.charAt(i) - '0' > Integer.MAX_VALUE % 10)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            no = no * 10 + s.charAt(i) - '0';
            i++;
        }
        return no * sign;
    }
}
