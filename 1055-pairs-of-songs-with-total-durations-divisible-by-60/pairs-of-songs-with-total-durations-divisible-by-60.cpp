class Solution {
public:
    int numPairsDivisibleBy60(vector<int>& time) {
        vector<int> reminderCount(60,0);
        int count=0;
        for(int t : time){
            int rem = t % 60;
            int comp=(60-rem) % 60;
            count += reminderCount[comp];
            reminderCount[rem]++;
        }
        return count;
    }
};