class Solution {
public:
    int majorityElement(vector<int>& nums) {
        int count=0;
        int candid=0;
        for (int num:nums){
            if (count==0){
                candid=num;
            }
            count +=(num==candid) ?1 : -1;
        }
        return candid;
    }
};