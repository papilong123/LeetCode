#include <vector>
#include <string>
#include <unordered_set>

using namespace std;

class Solution {
public:
    int totalNQueens(int n) {
        vector<int> stack;
        vector<vector<string>> res;
        unordered_set<int> col;
        unordered_set<int> master;
        unordered_set<int> vice;

        dfs(0,n,master,vice,col,stack,res);

        return res.size();
    }

    void dfs(int row,
            int n,
            unordered_set<int>& master,
            unordered_set<int>& vice,
            unordered_set<int>& col,
            vector<int>& stack,
            vector<vector<string>>& res){

        if(row==n){
            res.push_back(convert2board(stack,n));
            return;
        }

        for(int i=0;i<n;i++){
            if(col.find(i)==col.end() && master.find(row+i)==master.end() && vice.find(row-i)==vice.end()){
                stack.push_back(i);
                master.insert(row+i);
                vice.insert(row-i);
                col.insert(i);

                dfs(row+1,n,master,vice,col,stack,res);

                stack.pop_back();
                master.erase(row+i);
                vice.erase(row-i);
                col.erase(i);
            }
        }
    }


    vector<string> convert2board(vector<int>& stack,int n){
        vector<string> strs;
        for(auto num: stack){
            string str=string(n,'.');
            str[num]='Q';
            strs.push_back(str);
        }
        return strs;
    }
};
