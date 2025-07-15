class Solution {
public:
    int guessNumber(int n) {
        int l = 1;
        int r = n;
        while (l < r) {
            int m = l + (r - l) / 2;
            int res = guess(m);
            if (res <= 0)
                r = m;
            else
                l = m + 1;
        }
        return l;
    }
};
