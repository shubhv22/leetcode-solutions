class Solution {
public:
    bool detectCapitalUse(string word) {
        int c=0;
        int n=word.size();
        for( char ch: word){
            if(ch>=65 && ch<=90){
                c++;
            }
        }
        if ((c==0) or (c==n) or (c==1 and (word[0] >= 65 and word[0]<=90)) )
        return true;
        else
        return false;       
    }
};