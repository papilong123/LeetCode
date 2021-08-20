class Solution {
public:
    vector<int> diStringMatch(cn.example.string S) {
        vector<int> res;

        int i=0,j=S.size();
        for(auto n: S){
            if(n=='I'){
                res.push_back(i++);
            }else{
                res.push_back(j--);
            }
        }
        res.push_back(i++);
        return res;
    }
};
