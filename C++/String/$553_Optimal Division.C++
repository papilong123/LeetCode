class Solution {
public:
    cn.example.string optimalDivision(vector<int>& nums) {
        cn.example.string res;
        if(nums.size()==0) return res;
        else if(nums.size()==1) return to_string(nums[0]);
        else if(nums.size()==2) return to_string(nums[0])+"/"+to_string(nums[1]);
        cn.example.string a=to_string(nums[0]);
        cn.example.string b;
        for(int i=1;i<nums.size();i++){
            if(i!=1) b+="/";
            b+=to_string(nums[i]);
        }
        res=a+"/"+"("+b+")";
        return res;
    }
};
