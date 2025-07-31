class Solution {
public:
    int passThePillow(int n, int time) {
        int cycle = 2 * (n - 1);
        time %= cycle;
        
        if (time < n - 1) {
            return 1 + time;
        } else {
            return n - (time - (n - 1));
        }
    }
};
