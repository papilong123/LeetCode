#include <vector>
using namespace std;
class Solution {
public:
    vector<int> findDisappearedNumbers(vector<int>& nums) {
        vector<int> res;
        if(nums.empty()) return res;

        for(int i=0;i<nums.size();i++){
            int index=(nums[i]-1)%nums.size();
            nums[index]+=nums.size();;
        }
        for(int j=0;j<nums.size();j++){
            if(nums[j]<=nums.size()){
                res.push_back(j+1);
            }
        }
        return res;
    }
};
