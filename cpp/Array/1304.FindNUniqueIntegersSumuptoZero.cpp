#include <vector>
using namespace std;

class Solution {
public:
    vector<int> sumZero(int n) {
        vector<int> nums(n);
        for(int i=0;i<nums.size();i++){
            nums[i]=2*i+1-n;
        }
        return nums;
    }
};
