class Solution {
public:
    string removeDuplicates(string s) {
        string p = "";
        stack<char>st;
        for(auto k:s){
            if(st.empty()||(!st.empty() && st.top()!=k))
            st.push(k);
            else
            st.pop();
        }
        while (!st.empty()){
            p = st.top() + p;
            st.pop();
        }
        return p;
    }
};