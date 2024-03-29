#include <vector>
#include <string>

using namespace std;

class Solution {
public:
    string addBinary(string a, string b) {
        string res(max(a.size(),b.size()),'0');
        int i=a.size()-1,j=b.size()-1,k=max(a.size(),b.size())-1;
        int carry=0;
        while(i>=0 || j>=0){
            int aa= i>=0?a[i--]-'0':0;
            int bb= j>=0?b[j--]-'0':0;
            int sum=aa+bb+carry;
            if(sum>=2){//判断是否进位
                res[k--] = (sum % 2)+'0';
                carry=1;
            }else{
                res[k--]=sum+'0';
                carry=0;
            }
        }
        if(carry==1){//最高一位进位
            res='1'+res;
        }
        return res;
    }
};
