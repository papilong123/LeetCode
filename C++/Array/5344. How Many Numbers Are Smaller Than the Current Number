class Solution {
public:
    vector<int> smallerNumbersThanCurrent(vector<int>& nums) {
        vector<int> res;
        vector<int> arr(102,0);
        for(auto num:nums){
            arr[num+1]++;
        }
        for(int i=1;i<=101;i++){
            arr[i]+=arr[i-1];
        }
        for(auto num:nums){
            res.push_back(arr[num]);
        }
        return res;
    }
};
