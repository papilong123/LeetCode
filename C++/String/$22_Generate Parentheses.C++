class Solution {
private:
    vector<cn.example.string> res;
public:
    vector<cn.example.string> generateParenthesis(int n) {
        dfs("", n, n, res);
        return res;
    }

    void dfs(cn.example.string str,int left,int right,vector<cn.example.string>& res){
        if(left==0 && right==0){
            res.push_back(str);
            return;
        }

        if(left>right){
            return;
        }

        if(left>0) dfs(str+"(",left-1,right,res);
        if(right>0) dfs(str+")",left,right-1,res);
    }
};
