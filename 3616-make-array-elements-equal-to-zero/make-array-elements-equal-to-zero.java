class Solution {
    public int countValidSelections(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        for (int i = 1; i < n; ++i) prefix[i] = prefix[i - 1] + nums[i - 1];
        for (int i = n - 2; i >= 0; --i) suffix[i] = suffix[i + 1] + nums[i + 1];
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if (nums[i] > 0) continue;
            if (prefix[i] == suffix[i]) ans += 2;
            else if (Math.abs(prefix[i] - suffix[i]) == 1) ans += 1;
        }
        return ans;
    }
}