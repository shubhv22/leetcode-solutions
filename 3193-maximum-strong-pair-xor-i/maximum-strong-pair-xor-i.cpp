class Solution {
public:
    int maximumStrongPairXor(vector<int>& nums) {
        int maxXorValue = 0;
        
        sort(nums.begin(), nums.end());

        for (int i = 0; i < nums.size(); ++i) {
            int x = nums[i];
            
            for (int j = i; j < nums.size(); ++j) {
                int y = nums[j];

                if (y <= 2 * x) {
                    maxXorValue = max(maxXorValue, x ^ y);
                } else {
                    break;
                }
            }
        }

        return maxXorValue;
    }
};