#include <vector>
using namespace std;

class Solution {
public:
    vector<vector<int>> generate(int numRows) {
        vector<vector<int>> res(numRows);
        if(numRows==0) return res;//返回空数组
        
        for(int i=0;i<numRows;i++){//给数组一个一个赋值
            for(int j=0;j<=i;j++){
                if((j==0||j==i)){
                    res[i].push_back(1);
                }else{
                    res[i].push_back(res[i-1][j-1]+res[i-1][j]);
                }
            }
        }
        return res;
    }
};
