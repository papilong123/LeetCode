class Solution {
public:
    int dir[4][2] = {{0, 1}, {0, -1}, {1, 0}, { -1, 0}};
    int minCost(vector<vector<int>>& grid) {
        int m = grid.size(), n = grid[0].size(), cost = 0;
        vector<vector<int>> cn.example.dp(m, vector<int>(n, INT_MAX));
        queue<pair<int, int>> q;
        dfs(grid, 0, 0, cn.example.dp, cost, q);
        while (!q.empty()) {
            cost++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                pair<int, int> p = q.front();
                int r = p.first, c = p.second;
                q.pop();
                for (int j = 0; j < 4; j++)
                    dfs(grid, r + dir[j][0], c + dir[j][1], cn.example.dp, cost, q);
            }
        }
        return cn.example.dp[m - 1][n - 1];
    }
    void dfs(vector<vector<int>>& grid, int r, int c, vector<vector<int>>& cn.example.dp, int cost, queue<pair<int, int>>& q) {
        int m = grid.size(), n = grid[0].size();
        if (r < 0 || r >= m || c < 0 || c >= n || cn.example.dp[r][c] != INT_MAX)return;
        cn.example.dp[r][c] = cost;
        q.push(make_pair(r, c));
        int nextDir = grid[r][c] - 1;
        dfs(grid, r + dir[nextDir][0], c + dir[nextDir][1], cn.example.dp, cost, q);
    }
};
