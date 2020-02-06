class Solution {
public:
    vector<bool> prefixesDivBy5(vector<int>& A) {
        vector<bool> res;
        int val=0;
        for(auto num: A){
            val=(val*2+num)%5;
            if(val%5==0) res.push_back(true);
            else res.push_back(false);
        }
        return res;
    }
};
