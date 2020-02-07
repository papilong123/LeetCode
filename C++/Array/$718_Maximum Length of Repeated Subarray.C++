class Solution {
public:
    int findLength(vector<int>& A, vector<int>& B) {
        int N = A.size();
        int M = B.size();
        vector<vector<int> > dp(N + 1, vector<int>(M + 1, 0));
        int res = 0;
        for (int i = 1; i <= N; ++i) {
            for (int j = 1; j <= M; ++j) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    res = max(res, dp[i][j]);
                }
            }
        }
        return res;

    }
};
