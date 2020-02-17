class Solution {
public:
    int minTimeToVisitAllPoints(vector<vector<int>>& points) {
        int res=0;
        for(int i=1;i<points.size();i++){
            vector<int> curr=points[i];
            vector<int> pre=points[i-1];
            res+=max(abs(curr[0]-pre[0]),abs(curr[1]-pre[1]));
        }
        return res;
    }
};
