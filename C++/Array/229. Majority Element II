class Solution {
public:
    vector<int> majorityElement(vector<int>& nums) {
        //摩尔投票法   boyer-moore
        vector<int> res;
        if(nums.size()==0) return res;
        int count1=0,count2=0,num1=nums[0],num2=nums[0];
        for(int i=0;i<nums.size();i++){
            // 若是其中任何一个，则对应计数器加一
            if(nums[i]==num1) {count1++;continue;}
            if(nums[i]==num2) {count2++;continue;}

            //若两者都不是，检查对应计数器是否为零，如果是零就对应计数器换成一且更换候补元素
            if(count1==0){
                num1=nums[i];
                count1=1;
                continue;
            }
            if(count2==0){
                num2=nums[i];
                count2=1;
                continue;
            }

            //两计数器都减一
            count1--;
            count2--;
        }

        //第二步，检查候补元素是否满足需要
        count1=0;
        count2=0;
        for(int i=0;i<nums.size();i++){
            if(nums[i]==num1) count1++;
            else if(nums[i]==num2) count2++;
        }
        if(count1>nums.size()/3) res.push_back(num1);
        if(count2>nums.size()/3) res.push_back(num2);

        return res;
    }
};
