import java.util.*;

class Solution {
    public int[] decimalRepresentation(int n) {
        List<Integer> result = new ArrayList<>();
        int place = 1;
        while (n > 0) {
            int digit = n % 10;
            if (digit > 0) {
                result.add(digit * place);
            }
            n /= 10;
            place *= 10;
        }
        Collections.reverse(result);
        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }
        return ans;
    }
}
