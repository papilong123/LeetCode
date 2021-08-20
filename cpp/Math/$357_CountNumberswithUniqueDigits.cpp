class Solution {
public:
    int countNumbersWithUniqueDigits(int n) {
        if(n==0) return 1;
        if(n==9) return 10;

        int res=0;
        vector<int> nums(n+1,1);
        nums[0]=1;
        nums[1]=9;
        res+=nums[0]+nums[1];
        for(int i=1;i<=min(n-1,9);i++){
            nums[i+1]=nums[i]*(10-i);
            res+=nums[i+1];
        }
        return res;
    }
};
