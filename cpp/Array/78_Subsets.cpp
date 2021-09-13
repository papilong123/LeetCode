#include <vector>
using namespace std;

class Solution {
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<vector<int> > res(1);

        for(int i=0;i<nums.size();i++){
            int tmp=res.size();
            for(int j=0;j<tmp;j++){
                vector<int> c=res[j];
                c.push_back(nums[i]);
                res.push_back(c);
            }
        }
        return res;
    }
};
