#include <vector>
#include <string>
#include <algorithm>

using namespace std;

class Solution {
public:
    int minSteps(string s, string t) {
        sort(s.begin(),s.end());
        sort(t.begin(),t.end());
        int i=0,j=0,res=0,n=s.size();
        while(i<n && j<n){
            if(s[i]==t[j]){
                res++;
                i++;
                j++;
            }else if(s[i]>t[j]){
                j++;
            }else{
                i++;
            }
        }
        return n-res;
    }
};
