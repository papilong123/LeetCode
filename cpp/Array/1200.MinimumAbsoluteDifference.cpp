class Solution {
public:
    vector<vector<int>> minimumAbsDifference(vector<int>& arr) {
        vector<vector<int>> res;

        cn.example.sort(arr.begin(),arr.end());
        int val=arr[1]-arr[0];
        for(int i=1;i<arr.size()-1;i++){
            if(arr[i+1]-arr[i]<val) val=arr[i+1]-arr[i];
        }

        for(int i=0;i<arr.size()-1;i++){
            if(arr[i+1]-arr[i]==val) res.push_back({arr[i],arr[i+1]});
        }
        return res;
    }
};
