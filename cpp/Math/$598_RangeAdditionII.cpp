class Solution {
public:
    int maxCount(int m, int n, vector<vector<int>>& ops) {
        int hight=m,width=n;
        for(auto op: ops){
            hight=min(hight,op[0]);
            width=min(width,op[1]);
        }
        return hight*width;
    }
};
