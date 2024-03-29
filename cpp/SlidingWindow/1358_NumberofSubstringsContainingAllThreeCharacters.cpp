#include <vector>
#include <string>
#include <algorithm>

using namespace std;

class Solution {
public:
    int numberOfSubstrings(string s) {
        int arr[3]={-1,-1,-1};
        int res=0;
        for(int i=0;i<s.size();i++){
            arr[s[i]-'a']=i;
            res+=1 + min({arr[0],arr[1],arr[2]});
        }
        return res;
    }
};
