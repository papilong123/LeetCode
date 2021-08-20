class Solution {
public:
    int numOfSubarrays(vector<int>& arr, int k, int threshold) {
        int res=0,sum=0;
        int left=0,right=k-1;
        for(int i=0;i<k;i++){//先加好第一组
            sum+=arr[i];
        }
        while(right<arr.size()-1){//留最后一组循环外判断
            if(sum>=k*threshold) res++;
            sum-=arr[left];
            left++;
            right++;
            sum+=arr[right];
        }
        if(sum>=k*threshold) res++;//检查最后一组数组是否符合要求
        return res;
    }
};
