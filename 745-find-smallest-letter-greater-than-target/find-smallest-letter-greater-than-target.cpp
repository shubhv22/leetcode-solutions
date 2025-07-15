class Solution {
public:
    char nextGreatestLetter(vector<char>& letters, char target) {
        int n = letters.size();
        int l = 0;
        int r = n;
        while(l<r)
        {
        int m = (l+r)/2;
        if (letters[m] > target)
        r = m;
        else
        l = m+1;
        }
        return letters[r%n];
        
    }
};