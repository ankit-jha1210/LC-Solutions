class Solution {

    public int romanToInt(String s) {
        int i = 0;
        int res = 0;
        int n = s.length();
        while (i < n) {
            if (s.charAt(i) == 'M') res += 1000; 
            else if (s.charAt(i) == 'D') res += 500; 
            else if(s.charAt(i) == 'L') res += 50;
            else if(s.charAt(i) == 'V') res += 5;
            else if (s.charAt(i) == 'C') {
                if (i + 1 < n) {
                    if (s.charAt(i + 1) == 'D') {
                        res += 400;
                        i += 2;
                        continue;
                    } else if (s.charAt(i + 1) == 'M') {
                        res += 900;
                        i += 2;
                        continue;
                    }
                }
                res += 100;
            } else if (s.charAt(i) == 'X') {
                if (i + 1 < n) {
                    if (s.charAt(i + 1) == 'L') {
                        res += 40;
                        i += 2;
                        continue;
                    } else if (s.charAt(i + 1) == 'C') {
                        res += 90;
                        i += 2;
                        continue;
                    }
                }
                res += 10;
            } else if (s.charAt(i) == 'I') {
                if (i + 1 < n) {
                    if (s.charAt(i + 1) == 'V') {
                        res += 4;
                        i += 2;
                        continue;
                    } else if (s.charAt(i + 1) == 'X') {
                        res += 9;
                        i += 2;
                        continue;
                    }
                }
                res += 1;
            }
            i++;
        }
        return res;
    }
}
