
Actually, this rule could be derived from constructing an arithmetic sequence.
(Note that any arithmetic sequence must have unique values if the cn.example.common delta is non-zero)
We need the sequence sum, so that
(a[0] + a[n-1]) * n / 2 = 0, which means a[0] + a[n-1] = 0.
Note that a[n-1] - a[0] = (n-1) * delta, which is -2 * a[0],
so we simply set delta = 2, a[0] = 1 - n

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
