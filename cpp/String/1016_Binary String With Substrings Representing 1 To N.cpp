#include <vector>
#include <string>
#include <bitset>

using namespace std;

class Solution {
public:
    bool queryString(string S, int N) {
        for(int i=N;i>N/2;i--){
            string str=bitset<32>(i).to_string();
            if(S.find(str.substr(str.find("1")))==string::npos) return false;
        }
        return true;
    }
};
