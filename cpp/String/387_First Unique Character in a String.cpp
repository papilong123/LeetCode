#include <vector>
#include <string>

using namespace std;

class Solution {
public:
    int firstUniqChar(string s) {
        int A[26]={0},count=0;
        for(int i=0;i<s.size();i++){
            A[s[i]-'a']++;
        }
        for(int i=0;i<s.size();i++){
            if(A[s[i]-'a']==1) return i;
        }
        return -1;
    }
};
