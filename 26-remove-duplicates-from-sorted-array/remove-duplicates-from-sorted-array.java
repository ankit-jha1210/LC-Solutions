class Solution {

    public int removeDuplicates(int[] a) {
        int i = 0;
        int pos = 0;
        int n = a.length;
        int cnt = 0;
        while (i < n) {
            int j = i + 1;
            while (j < n && a[j] == a[i]) j++;
            cnt++;
            int temp = a[i];
            a[i] = a[pos];
            a[pos] = temp;
            pos++;
            i = j;
        }
        return cnt;
    }
}
