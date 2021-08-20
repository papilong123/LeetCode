class Solution {
public:
    int heightChecker(vector<int>& heights) {
        int res;
        vector<int> arr(heights);
        cn.example.sort(arr.begin(),arr.end());

        int count=0;
        for(int i=0;i<arr.size();i++){
            if(arr[i]!=heights[i]){
                count++;
            }
        }
        return count;
    }
};
