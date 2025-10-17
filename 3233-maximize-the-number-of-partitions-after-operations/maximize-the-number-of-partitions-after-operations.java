class Solution {
    public int maxPartitionsAfterOperations(String s, int k) {
        Map<Long, Integer> memo = new HashMap<>();
        return dfs(s, 0, true, 0, k, memo) + 1;
    }

    private int dfs(String s, int i, boolean canChange, int mask, int k, Map<Long, Integer> memo) {
        int n = s.length();
        if (i == n) return 0;
        long key = (((long)i) << 27) | ((canChange ? 1L : 0L) << 26) | (mask & ((1 << 26) - 1));
        if (memo.containsKey(key)) return memo.get(key);

        int res = getRes(s, i, canChange, mask, 1 << (s.charAt(i) - 'a'), k, memo);
        if (canChange) {
            for (int c = 0; c < 26; c++) {
                int newBit = 1 << c;
                res = Math.max(res, getRes(s, i, false, mask, newBit, k, memo));
            }
        }
        memo.put(key, res);
        return res;
    }

    private int getRes(String s, int i, boolean nextCanChange, int mask, int newBit, int k, Map<Long, Integer> memo) {
        int newMask = mask | newBit;
        if (Integer.bitCount(newMask) > k) {
            return 1 + dfs(s, i + 1, nextCanChange, newBit, k, memo);
        } else {
            return dfs(s, i + 1, nextCanChange, newMask, k, memo);
        }
    }
}
