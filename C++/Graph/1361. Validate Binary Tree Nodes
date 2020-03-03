class Solution {
public:
    bool validateBinaryTreeNodes(int n, vector<int>& leftChild, vector<int>& rightChild) {
        vector<int> nums(n,0);
        for(auto num: leftChild){
            if(num!=-1) nums[num]++;
        }
        for(auto num: rightChild){
            if(num!=-1) nums[num]++;
        }
        // 只有一个0的入度，没有大于1的入度
        int count0=0,count=0;
        for(auto num: nums){
            if(num==0) count0++;
            if(num>1) count++;
        }
        return count0==1 && count==0;
    }
};
