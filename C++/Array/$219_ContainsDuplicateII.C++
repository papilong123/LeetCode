class Solution {
public:
    bool containsNearbyDuplicate(vector<int>& nums, int k) {
        unordered_set<int> set; //搜索、插入和移除平均常数时间复杂度，不会超时
    for(int i = 0; i < nums.size(); i++)
    {
        if(set.find(nums[i]) != set.end())
            return true;
        set.insert(nums[i]);
        if(set.size() > k )
            set.erase(nums[i-k]); //滑动窗口长度最大为k 
    }
    return false;
    }
};
