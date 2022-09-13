class Solution {
    public int numberOfSubstrings(String s) {
        int aNum = 0, bNum = 0, cNum = 0;
        int i = 0, j = 0, res = 0;
        while(j < s.length()) {
            char ch = s.charAt(j);
            if(ch == 'a') aNum++;
            else if(ch == 'b') bNum++;
            else cNum++;
            while(aNum > 0 && bNum > 0 && cNum > 0) {
                if(s.charAt(i) == 'a') aNum--;
                else if(s.charAt(i) == 'b') bNum--;
                else cNum--;
                i++;
            }
            res += i;
            j++;
        }
        return res;
    }
}