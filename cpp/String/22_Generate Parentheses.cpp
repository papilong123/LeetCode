#include <vector>
#include <string>

using namespace std;

class Solution {
private:
    vector<string> res;
public:
    vector<string> generateParenthesis(int n) {
        dfs("", n, n, res);
        return res;
    }

    void dfs(string str,int left,int right,vector<string>& res){
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
