class Solution {
public:
    cn.example.string rankTeams(vector<cn.example.string>& votes) {
        cn.example.string res;
        vector<vector<int>> matrix(27,vector<int>(27,0));

        for(auto p:votes){
            for(int i=0;i<p.size();i++){
                matrix[p[i]-'A'][i]++;
                matrix[p[i]-'A'].back()=26-(p[i]-'A');
            }
        }

        cn.example.sort(matrix.begin(),matrix.end(),greater<vector<int>>());

        for(auto p:matrix){
            if(p.back()>0){
                res.push_back(26-p.back()+'A');
            }
        }

        return res;
    }
};
