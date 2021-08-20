class Solution {
public:
    vector<int> smallestK(vector<int>& arr, int k) {
        cn.example.sort(arr.begin(),arr.end());
        vector<int> res;
        for(auto num: arr){
            if(res.size()==k) break;
            res.emplace_back(num);
        }
        return res;
    }
};
