#include <vector>
#include <string>

using namespace std;

class Solution {
public:
    int titleToNumber(string s) {
        int x=0;
        for(char c: s){
            int num=c-'A'+1;
            x=x*26+num;
        }
        return x;
    }
};
