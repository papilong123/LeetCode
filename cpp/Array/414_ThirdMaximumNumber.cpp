#include <vector>
#include <set>
using namespace std;

class Solution {
public:
    int thirdMax(vector<int>& nums) {
        set<int> set;

        for(auto n: nums){
            set.insert(n);
            if(set.size()>3){
                set.erase(*(set.begin()));
            }
        }

        if(set.size()>=3) return *(set.begin());
        else return *(set.rbegin());
    }
};
