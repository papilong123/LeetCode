class Solution {
public:
    vector<int> res;

    vector<int> closestDivisors(int num) {
        res.push_back(0);
        res.push_back(1e9);
        helper(num+1);
        helper(num+2);
        return res;
    }

    void helper(int n){
        for(int i=sqrt(n);i>0;i--){
            if(n%i==0)
                if(abs(n/i-i)-abs(res[0]-res[1])<0){
                    res[0]=n/i;
                    res[1]=i;
                }
        }
    }
};
