class Solution {
    static final int MOD = 1_000_000_007;

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;
        int[][] dpPrev = new int[m][3];
        int[][] dpCurr = new int[m][3];

        for (int x = 0; x < m; x++) dpPrev[x][0] = 1;

        for (int i = 2; i <= n; i++) {
            int[] pref0 = new int[m + 1];
            int[] pref1 = new int[m + 1];
            int[] pref2 = new int[m + 1];
            long total0 = 0, total1 = 0, total2 = 0;

            for (int x = 0; x < m; x++) {
                total0 = (total0 + dpPrev[x][0]) % MOD;
                total1 = (total1 + dpPrev[x][1]) % MOD;
                total2 = (total2 + dpPrev[x][2]) % MOD;

                pref0[x + 1] = (int) ((pref0[x] + dpPrev[x][0]) % MOD);
                pref1[x + 1] = (int) ((pref1[x] + dpPrev[x][1]) % MOD);
                pref2[x + 1] = (int) ((pref2[x] + dpPrev[x][2]) % MOD);
            }

            for (int x = 0; x < m; x++) {
                dpCurr[x][0] = 0;
                dpCurr[x][1] = (pref0[x] + pref2[x]) % MOD;
                long valDown = (total0 + total1 - pref0[x + 1] - pref1[x + 1]) % MOD;
                if (valDown < 0) valDown += MOD;
                dpCurr[x][2] = (int) valDown;
            }

            int[][] tmp = dpPrev;
            dpPrev = dpCurr;
            dpCurr = tmp;
        }

        long ans = 0;
        for (int x = 0; x < m; x++) {
            for (int d = 0; d < 3; d++) {
                ans = (ans + dpPrev[x][d]) % MOD;
            }
        }
        return (int) ans;
    }
}
