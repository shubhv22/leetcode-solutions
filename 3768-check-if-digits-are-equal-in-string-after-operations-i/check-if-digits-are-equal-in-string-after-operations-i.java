class Solution {
    public boolean hasSameDigits(String s) {
        int n = s.length();
        int[] digits = new int[n];
        for (int i = 0; i < n; i++) digits[i] = s.charAt(i) - '0';
        int len = n;
        while (len > 2) {
            for (int i = 0; i < len - 1; i++) digits[i] = (digits[i] + digits[i + 1]) % 10;
            len--;
        }
        return digits[0] == digits[1];
    }
}
