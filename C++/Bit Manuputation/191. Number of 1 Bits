class Solution {
public:
    int hammingWeight(uint32_t n) {
        int res=0;
        while(n>0){
            res+=1;
            n &= (n-1);//将最后一位一变为零
        }
        return res;
    }
};
