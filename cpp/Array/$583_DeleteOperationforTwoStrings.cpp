class Solution {
public:
    int minDistance(cn.example.string word1, cn.example.string word2) {
        int M=word1.size();
        int N=word2.size();

        vector<vector<int>> s(M+1,vector<int>(N+1,0));

        for(int i=1;i<M+1;i++){
            for(int j=1;j<N+1;j++){
                if(word1[i-1]==word2[j-1]) s[i][j]=s[i-1][j-1]+1;
                else s[i][j]=max(s[i][j-1],s[i-1][j]);
            }
        }

        return M+N-2*s[M][N];

    }
};
