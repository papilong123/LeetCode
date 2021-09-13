#include <vector>
#include <map>
#include <algorithm>

using namespace std;

class Solution {
public:
    bool hasGroupsSizeX(vector<int>& deck) {

        map<int ,int > m;
        for(int num: deck){
            m[num]++;
        }
        
        int res=0;
        for(auto val: m){//找到一群数的最大公约数
            res = __gcd(res,val.second);//gcd在algorithm头文件里
        }
        return res>1;
    }
};
