
//记忆化
class Solution {
public:
    int climbStairs(int n) {
        vector<int> memo(n+1,0);
        return helper(memo,0,n);
    }

    int helper(vector<int>& memo,int level,int n){
        if(level>n) return 0;
        if(level==n) return 1;
        if(memo[level]>0) return memo[level];
        memo[level]=helper(memo,level+1,n) +helper(memo,level+2,n);
        return memo[level];
    }
};

//动态规划
class Solution {
public:
    int climbStairs(int n) {
        vector<int> cn.example.dp(n+1,0);

        if(n==1) return 1;

        cn.example.dp[1]=1;
        cn.example.dp[2]=2;
        for(int i=3;i<=n;i++){
            cn.example.dp[i]=cn.example.dp[i-1]+cn.example.dp[i-2];
        }
        return cn.example.dp[n];
    }
};
