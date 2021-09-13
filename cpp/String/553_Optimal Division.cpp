#include <vector>
#include <string>

using namespace std;

class Solution {
public:
    string optimalDivision(vector<int>& nums) {
        string res;
        if(nums.size()==0) return res;
        else if(nums.size()==1) return to_string(nums[0]);
        else if(nums.size()==2) return to_string(nums[0])+"/"+to_string(nums[1]);
        string a=to_string(nums[0]);
        string b;
        for(int i=1;i<nums.size();i++){
            if(i!=1) b+="/";
            b+=to_string(nums[i]);
        }
        res=a+"/"+"("+b+")";
        return res;
    }
};
