class Solution {
public:
    string makeGood(string s) {
        string str="";
        stack<char> st;
        for(int i=0; i<s.size(); i++){
            if(st.empty()) st.push(s[i]);
            else if (abs(st.top()-s[i])==32) st.pop();
            else st.push(s[i]);
        }
        while (!st.empty()){
            str=st.top()+str;
            st.pop();
        }
        return str;
    }
};