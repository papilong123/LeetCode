#include <vector>
#include <string>
#include <algorithm>

using namespace std;

class Solution {
public:
    string reverseStr(string s, int k) {
        for(int i=0;i<s.size()/(2*k);i++){
            reverse(s.begin()+2*i*k,s.begin()+(2*i+1)*k);
        }
        int t=s.size()%(2*k);
        if(t<=k){
            reverse(s.end()-t,s.end());
        }else{
            reverse(s.end()-t,s.end()-t+k);
        }
        return s;
    }
};
