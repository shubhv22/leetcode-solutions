class Solution {
public:
    bool checkRecord(string s) {
        int countA = 0;
        int countL = 0;

        for (char ch : s) {
            if (ch == 'A') {
                countA++;
                if (countA > 1)
                    return false;
                countL = 0;
            } else if (ch == 'L') {
                countL++;
                if (countL > 2)
                    return false;
            } else {
                countL = 0;
            }
        }

        return true;
    }
};
