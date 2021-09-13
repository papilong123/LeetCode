#include <vector>
#include <string>

using namespace std;

class Solution {
public:
    vector<int> singleNumber(vector<int>& nums) {
        int cur=0,x=0;
        //用位掩码记录取得的出新次数是奇数还是偶数
        for(int i=0;i<nums.size();i++) cur^=nums[i];
        int bitmask=cur&(-cur);//获得最后一位1
        for(int i=0;i<nums.size();i++){
            //最后一位掩码来自x或y,0(x)与位掩码处是一出现偶数次的元素和x元素异或，得到x
            if((nums[i] & bitmask) != 0)  x^=nums[i];
        }
        return {x,cur^x};
    }
};

