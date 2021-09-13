#include <vector>
#include <string>
#include <algorithm>

using namespace std;

class Solution {
public:
    string addStrings(string num1, string num2) {
        int carry=0,i=num1.size()-1,j=num2.size()-1;
        string res;
        while(i>=0||j>=0){
            int t1= i>=0 ? num1[i]-'0' : 0;
            int t2= j>=0 ? num2[j]-'0' : 0;
            int tmp=t1+t2+carry;
            carry=tmp/10;
            res+= to_string( tmp%10 );
            i--;
            j--;
        }
        if(carry==1){
            res+='1';
        }
        reverse(res.begin(),res.end());
        return res;
    }
};
