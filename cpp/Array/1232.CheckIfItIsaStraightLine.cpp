class Solution {
public:
    bool checkStraightLine(vector<vector<int>>& coordinates) {
        vector<int> nums;
        nums.push_back(coordinates[1][0]-coordinates[0][0]);
        nums.push_back(coordinates[1][1]-coordinates[0][1]);
        auto curr=nums;
        int i=2;
        while(i<coordinates.size()){
            nums[0]=coordinates[i][0]-coordinates[0][0];
            nums[1]=coordinates[i][1]-coordinates[0][1];
            if(nums[0]*curr[1]!=nums[1]*curr[0]){
                return false;
            }
            i++;
        }
        return true;
    }
};
