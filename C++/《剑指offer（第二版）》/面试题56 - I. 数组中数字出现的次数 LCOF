class Solution {
public:
    vector<int> singleNumbers(vector<int>& nums) {
        int bitmask=0;
        for(auto num : nums) bitmask ^= num;
        int right_most=1;
        while((bitmask & right_most)==0){
            right_most <<=1;
        }
        int a=0,b=0;
        for(auto num : nums)
            if((right_most & num)!=0)
                a^=num;
        return {a,bitmask^a};
    }
};
