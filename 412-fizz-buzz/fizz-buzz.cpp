class Solution {
public:
    vector<string> fizzBuzz(int n) {
        vector<string> shubh;
        for(int i = 1; i<=n; i++){
            string s;

            if(i%3==0)
            s+="Fizz";
            if(i%5==0)
            s+="Buzz";
            shubh.push_back(s.empty() ? to_string(i) : s);
        }
        return shubh;
    }        
};