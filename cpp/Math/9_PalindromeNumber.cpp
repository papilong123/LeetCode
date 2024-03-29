#include <vector>
#include <string>

using namespace std;

class Solution {
public:
    bool isPalindrome(int x) {
        if(x<0) return false;
        if(x==0) return true;

        string str=to_string(x);
        int i=0,j=str.size()-1;
        while(i<j && str[i]==str[j]){
            i++;
            j--;
        }

        if(i==j || i-1==j) return true;
        return false;
    }
};
