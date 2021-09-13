#include <vector>
#include <string>

using namespace std;

class Solution {
public:
    vector<string> summaryRanges(vector<int>& nums) {
        vector<string> res;

        if(nums.size()==0) return res;

        int left=0;
        int right=0;

        for(int i=1;i<nums.size();i++){
            if((long)nums[i]-(long)nums[i-1]>1){
                res.push_back(convert(nums[left],nums[right]));
                left=right=i;
            }else{
                right=i;
            }
        }
        res.push_back(convert(nums[left],nums[right]));

        return res;
    }

    string convert(int a,int b){
        if(a==b){
            return to_string(a);
        }else{
            return to_string(a)+"->"+to_string(b);
        }
    }
};
