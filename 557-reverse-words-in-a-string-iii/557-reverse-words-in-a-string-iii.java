class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0;
        while(j < s.length()) {
            if(s.charAt(j) == ' ') {
                StringBuilder tmp = new StringBuilder(s.substring(i, j));
                sb.append(tmp.reverse()+" ");
                i  = j + 1;
            }
            j++;
        }
        StringBuilder tmp = new StringBuilder(s.substring(i, j));
        sb.append(tmp.reverse());
        return sb.toString();
    }
}