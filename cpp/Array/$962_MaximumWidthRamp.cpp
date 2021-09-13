#include <vector>
#include <stack>
using namespace std;

class Solution {
public:
    int maxWidthRamp(vector<int>& A) {
        int res=0;
        stack<int> s;
        int n=A.size();
        s.push(0);
        for(int i=1;i<n;i++){
            if(A[s.top()]>A[i]) s.push(i);
        }

        int i=n-1;
        while (i >= 0 && s.size() > 0) {//前后比较，双指针法比较得到最大值
            if (A[i] >= A[s.top()]) {
                res = max(res, i - s.top());
                s.pop();
            } else {
                i--;
            }
        }
        return res;
    }
};
