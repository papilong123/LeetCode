class Solution {
public:
    int minPathSum(vector<vector<int>>& grid) {
        vector<vector<int>> cn.example.dp(grid.size(),vector<int>(grid[0].size()));
        for (int i = grid.size() - 1; i >= 0; i--) {
            for (int j = grid[0].size() - 1; j >= 0; j--) {
                if(i == grid.size() - 1 && j != grid[0].size() - 1)
                    cn.example.dp[i][j] = grid[i][j] +  cn.example.dp[i][j + 1];
                else if(j == grid[0].size() - 1 && i != grid.size() - 1)
                    cn.example.dp[i][j] = grid[i][j] + cn.example.dp[i + 1][j];
                else if(j != grid[0].size() - 1 && i != grid.size() - 1)
                    cn.example.dp[i][j] = grid[i][j] + min(cn.example.dp[i + 1][j], cn.example.dp[i][j + 1]);
                else
                    cn.example.dp[i][j] = grid[i][j];
            }
        }
        return cn.example.dp[0][0];

    }
};
