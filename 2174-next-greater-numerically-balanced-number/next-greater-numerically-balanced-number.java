class Solution {
    public int nextBeautifulNumber(int n) {
        int candidate = n + 1;
        while (!isBalanced(candidate)) candidate++;
        return candidate;
    }
    private boolean isBalanced(int num) {
        int[] count = new int[10];
        int x = num;
        while (x > 0) {
            int d = x % 10;
            if (d == 0) return false;
            count[d]++;
            x /= 10;
        }
        for (int d = 1; d <= 9; d++) {
            if (count[d] > 0 && count[d] != d) return false;
        }
        return true;
    }
}