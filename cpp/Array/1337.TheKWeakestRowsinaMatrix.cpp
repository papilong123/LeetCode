#include <vector>
#include <algorithm>
#include <numeric>

using namespace std;


class Solution {
public:
    vector<int> kWeakestRows(vector<vector<int>>& mat, int k) {
        vector<pair<int,int>> arr;
        vector<int> res;
        for(int i=0;i<mat.size();i++){
            int sum=accumulate(mat[i].begin(),mat[i].end(),0);
            arr.emplace_back(sum,i);
        }
        sort(arr.begin(),arr.end());
        for(int i=0;i<k;i++){
            res.emplace_back(arr[i].second);
        }
        return res;
    }
};
