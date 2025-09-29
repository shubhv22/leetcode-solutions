class Solution {
    public int numOfSubarrays(int[] arr) {
        int MOD = 1_000_000_007;
        long res = 0;
        int odd = 0, even = 1;
        int prefix = 0;
        
        for (int num : arr) {
            prefix += num;
            if (prefix % 2 == 0) {
                res += odd;
                even++;
            } else {
                res += even;
                odd++;
            }
            res %= MOD;
        }
        
        return (int) res;
    }
}