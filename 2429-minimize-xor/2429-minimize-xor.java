class Solution {
    public int minimizeXor(int num1, int num2) {
        int cnt = 0;
        while(num2 != 0) {
            num2 = (num2 & num2 -1);
            cnt++;
        }
        int num = 0;
        for(int i = 31; i >=0; i--) {
            int mask = (1 << i);
            if((num1 & mask) != 0) {
                if(cnt != 0) {
                    num = (num | mask);
                    cnt--;
                }
            }
            else {
                if(cnt > i) {
                    num = (num | mask);
                    cnt--;
                }
            }
        }
        return num;
    }
}