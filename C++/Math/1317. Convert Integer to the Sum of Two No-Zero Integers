class Solution {
public:

    bool helper(int num){
        while(num>0){
            if(num%10==0) return false;
            num/=10;
        }
        return true;
    }

    vector<int> getNoZeroIntegers(int n) {
        for(int i=1;i<n;i++){
            if(helper(i)&&helper(n-i)){
                return{i,n-i};
            }
        }
        return {};
    }
};
