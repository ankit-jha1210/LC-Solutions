class Solution {

    public int strStr(String haystack, String needle) {
        int i = 0;
        while (i < haystack.length()) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                int j = 0;
                int i1 = i;
                while (j < needle.length() && i1<haystack.length()) {
                    if (haystack.charAt(i1) == needle.charAt(j)) {
                        i1++;
                        j++;
                    }
                    else break;
                }
                if (j == needle.length()) return i;
            }
            i++;
        }
        return -1;
    }
}
