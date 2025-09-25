import java.util.*;

public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (denominator == 0) return "";
        if (numerator == 0) return "0";

        StringBuilder res = new StringBuilder();
        if ((numerator < 0) ^ (denominator < 0)) res.append("-");

        long num = Math.abs((long) numerator), den = Math.abs((long) denominator);
        res.append(num / den);
        long rem = num % den;
        if (rem == 0) return res.toString();

        res.append(".");
        Map<Long, Integer> seen = new HashMap<>();
        while (rem != 0) {
            if (seen.containsKey(rem)) {
                int idx = seen.get(rem);
                res.insert(idx, "(").append(")");
                break;
            }
            seen.put(rem, res.length());
            rem *= 10;
            res.append(rem / den);
            rem %= den;
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Arrays.asList(
            new int[]{1, 2},
            new int[]{2, 1},
            new int[]{2, 3},
            new int[]{-50, 8},
            new int[]{7, -12}
        ).forEach(arr -> System.out.println(s.fractionToDecimal(arr[0], arr[1])));
    }
}
