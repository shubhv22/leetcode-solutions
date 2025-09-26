class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        final int MOD = 1_000_000_007;
        long[] dp = new long[n + 1];
        long[] pre = new long[n + 2]; 
        dp[1] = 1;
        pre[1] = 1;
        for (int day = 2; day <= n; day++) {
            int start = Math.max(1, day - forget + 1);
            int end = Math.max(0, day - delay);
            dp[day] = (pre[end] - pre[start - 1] + MOD) % MOD;
            pre[day] = (pre[day - 1] + dp[day]) % MOD;
        }
        long ans = 0;
        for (int day = n - forget + 1; day <= n; day++) {
            if (day > 0) ans = (ans + dp[day]) % MOD;
        }
        return (int) ans;
    }
}