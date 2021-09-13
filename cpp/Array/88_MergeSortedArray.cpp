#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
    void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
        for(auto t : nums2){
            nums1[m++]=t;
        }
        sort(nums1.begin(),nums1.end());
    }
};
