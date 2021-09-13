#include <vector>
#include <string>

using namespace std;

class Solution {
public:
    string multiply(string num1, string num2) {
        if(num1[0]=='0'||num2[0]=='0') return "0";
        int n=num1.size()+num2.size();
        string res(n,'0');
        for(int i=num1.size()-1;i>=0;i--){
            int m=n-1;
            int mcarry=0,acarry=0;
            m-=(num1.size()-1-i);
            for(int j=num2.size()-1;j>=0;j--,m--){//个位数乘以一个多位数，进位法
                int multi=(num1[i]-'0')*(num2[j]-'0')+mcarry;
                mcarry=multi/10;
                int add=res[m]-'0'+multi%10+acarry;
                res[m]=add%10+'0';
                acarry=add/10;
            }
            if(mcarry) res[m]+=mcarry;
            if(acarry) res[m]+=acarry;
        }

        //删去多余的空格符
        for(int i=0;i<res.size();i++){
            if( res[i] != '0')
            return res.substr(i);
        }
        return " ";
    }
};

