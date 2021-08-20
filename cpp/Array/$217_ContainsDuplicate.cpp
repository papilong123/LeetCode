class Solution {
public:
    bool containsDuplicate(vector<int>& nums) {
        set s(nums.begin(),nums.end());
        return s.size()!=nums.size();
    }
};
