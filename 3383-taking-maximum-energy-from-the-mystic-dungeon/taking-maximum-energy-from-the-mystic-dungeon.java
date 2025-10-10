class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length;
        int ans = Integer.MIN_VALUE;
        for (int start = 0; start < k; start++) {
            int last = start + ((n - 1 - start) / k) * k;
            int cur = 0, best = Integer.MIN_VALUE;
            for (int j = last; j >= start; j -= k) {
                cur += energy[j];
                best = Math.max(best, cur);
            }
            ans = Math.max(ans, best);
        }
        return ans;
    }
}