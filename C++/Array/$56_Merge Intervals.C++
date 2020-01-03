class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        vector<vector<int>> res;
        if(intervals.empty()) return res;
        sort(intervals.begin(),intervals.end());
        int index=0;
        res.push_back(intervals[0]);

        for(int i=1;i<intervals.size();i++){
            if(res[index][1]>=intervals[i][0]){
                if(res[index][1]<intervals[i][1]){
                    res[index][1]=intervals[i][1];
                }
            }else{
                res.push_back(intervals[i]);
                index++;
            }
        }
        return res;
    }
};
