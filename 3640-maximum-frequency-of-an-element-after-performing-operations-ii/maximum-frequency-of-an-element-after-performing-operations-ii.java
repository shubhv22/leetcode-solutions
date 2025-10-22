class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        Map<Long, Integer> cnt = new HashMap<>();
        Map<Long, Integer> diff = new HashMap<>();
        for (int x : nums) {
            long val = x;
            cnt.put(val, cnt.getOrDefault(val, 0) + 1);
            diff.put(val, diff.getOrDefault(val, 0));
            diff.put(val - k, diff.getOrDefault(val - k, 0) + 1);
            diff.put(val + k + 1, diff.getOrDefault(val + k + 1, 0) - 1);
        }
        List<Long> keys = new ArrayList<>(diff.keySet());
        Collections.sort(keys);
        int ans = 0, s = 0;
        for (long v : keys) {
            s += diff.get(v);
            int already = cnt.getOrDefault(v, 0);
            int possible = Math.min(s, already + numOperations);
            ans = Math.max(ans, possible);
        }
        return ans;
    }
}
