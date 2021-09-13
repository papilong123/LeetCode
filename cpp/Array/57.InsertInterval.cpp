#include <vector>
using namespace std;


class Solution {
public:
    vector<vector<int>> insert(vector<vector<int>>& intervals, vector<int>& newInterval) {
        int k=0;                                    //要添加区间的索引
        vector<vector<int>> res;                    //答案
        while(k<intervals.size() && intervals[k][1]<newInterval[0]){//已有区间的末尾位置小于新区间的起始位置，加入答案中
            res.push_back(intervals[k++]);
        }
        while(k<intervals.size() && intervals[k][0]<=newInterval[1]){//已有区间的起始位置<=新区间的末尾位置,取左边最小值，右边最大值
            newInterval[0]=min(newInterval[0],intervals[k][0]);
            newInterval[1]=max(newInterval[1],intervals[k][1]);
            k++;
        }
        res.push_back(newInterval);
        while(k<intervals.size()){//把剩下的区间加入答案中
            res.push_back(intervals[k++]);
        }
        return res;
    }
};
