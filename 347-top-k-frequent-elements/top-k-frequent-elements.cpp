class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        map<int, int> f;
        for(auto k:nums){
            f[k]++;
        }
        vector<pair<int, int>> arr;
        for(auto k:f){
            arr.push_back({ k.second, k.first});
        }
        sort(arr.rbegin(), arr.rend());
        vector<int> res;
        for(int i=0; i<k; ++i){
            res.push_back(arr[i].second);
        }
        return res;
    }
};