class Solution {
public:
    int flipLights(int n, int p) {
        n = min(n,3);
        if(p==0){
            return 1;
        }
        if(p==1){
            return(n==1)? 2: (n==2)? 3:4;
        }
        if(p==2){
            return(n==1)? 2: (n==2)? 4:7;
        }
        return (1<<n);        
    }
};