class Solution {
    public int[] findEvenNumbers(int[] digits) {
        Set<Integer> set = new HashSet<>();
        int n = digits.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == i) continue;
                for (int k = 0; k < n; k++) {
                    if (k == i || k == j) continue;
                    int d1 = digits[i], d2 = digits[j], d3 = digits[k];
                    int num = d1 * 100 + d2 * 10 + d3;
                    if (d1 != 0 && (d3 % 2 == 0)) {
                        set.add(num);
                    }
                }
            }
        }
        int[] ans = new int[set.size()];
        int idx = 0;
        for (int x : set) {
            ans[idx++] = x;
        }
        Arrays.sort(ans);
        return ans;
    }
}
