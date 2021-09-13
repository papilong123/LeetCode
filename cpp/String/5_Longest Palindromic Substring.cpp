#include <vector>
#include <string>

using namespace std;


class Solution {
public:
    string longestPalindrome(string s) {
        int n=s.size();
        int len=0,start=0,end=0;
        for(int i=0;i<n;i++){
            int len1=helper(s,i,i);
            int len2=helper(s,i,i+1);
            len=max(max(len1,len2),len);
            if(len>end-start+1){
                start=i-(len-1)/2;
                end=i+len/2;
            }
        }
        return s.substr(start,len);
    }

    //返回回文字串的长度
    private:
    int helper(string s,int i,int j){
        while(i>=0 && j<s.size() && s[i]==s[j]){
            i--;
            j++;
        }
        return j-i-1;
    }
};
