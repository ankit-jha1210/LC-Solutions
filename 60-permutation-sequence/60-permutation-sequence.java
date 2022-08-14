class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> lst = new ArrayList<>();
        int fact = 1;
        for(int i = 1;i<n;i++){
            lst.add(i);
            fact *= i;
        }
        String res = "";
        lst.add(n);
        k--;
        while(true){
            res += lst.get(k/fact);
            lst.remove(k/fact);
            if(lst.size() == 0) break;
            k = k % fact;
            fact = fact/lst.size();
        }
        return res;
    }
}