#include <vector>
#include <algorithm>

using namespace std;

class Solution
{
public:
    // 去重+排序+滑动窗口
    int minOperations(vector<int>& nums)
    {
        int n = (int)nums.size();
        sort(nums.begin(), nums.end());
        nums.erase(unique(nums.begin(), nums.end()), nums.end());

        int an = (int)nums.size();
        int cur = 0;
        int r = 0;
        for (int l = 0; l < an; l ++)
        {
            while (r + 1 < an && nums[r + 1] - nums[l] <= n - 1)
                r ++;
            cur = max(cur, r - l + 1);
        }

        return n - cur;
    }
};
