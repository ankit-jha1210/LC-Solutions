class Solution {
    public int distinctPrimeFactors(int[] nums) {
       List<Integer> primes = getPrimes(nums, 1001);
       int cnt = 0;
       for(int p: primes) {
           for(int num: nums) {
               if(num % p == 0) {
                   cnt++;
                   break;
               }
           }
       }
       return cnt;
        
       
    }

    List<Integer> getPrimes(int[] nums, int n) {
         boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        for(int i = 2; i <= n; i++) {
            if(isPrime[i]) {
                for(int j = 2 * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        for(int i = 2; i <= n; i++) {
            if(isPrime[i]) res.add(i);
        }
        return res;
    }
}