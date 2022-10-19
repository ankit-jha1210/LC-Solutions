class Solution {

    public String countAndSay(int n) {
        if (n == 1) return "1";
        String small = countAndSay(n - 1);
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < small.length()) {
            int j = i + 1;
            while (j < small.length() && small.charAt(j) == small.charAt(i)) j++;
            sb.append(j - i);
            sb.append(small.charAt(i)+"");
            i = j;
        }
        return sb.toString();
    }
}
