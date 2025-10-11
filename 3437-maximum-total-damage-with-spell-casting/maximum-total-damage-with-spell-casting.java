class Solution {
    public long maximumTotalDamage(int[] power) {
        Map<Integer, Long> freq = new HashMap<>();
        for (int p : power) freq.put(p, freq.getOrDefault(p, 0L) + 1);
        List<Integer> vals = new ArrayList<>(freq.keySet());
        Collections.sort(vals);

        int n = vals.size();
        long[] dp = new long[n];
        dp[0] = vals.get(0) * freq.get(vals.get(0));
        for (int i = 1; i < n; i++) {
            long damage = (long) vals.get(i) * freq.get(vals.get(i));
            int j = i - 1;
            while (j >= 0 && vals.get(i) - vals.get(j) < 3) j--;
            long include = damage + (j >= 0 ? dp[j] : 0);
            long exclude = dp[i - 1];
            dp[i] = Math.max(include, exclude);
        }
        return dp[n - 1];
    }
}
