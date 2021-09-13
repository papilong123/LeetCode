#include <vector>
#include <string>

using namespace std;

class Solution {
public:
    string numberToWords(int num) {
        if(num==0) return "Zero";
        else return f(num).substr(1);
    }
private:
    static const char * const a_20[];
    static const char * const a_100[];
    static string f(int n){
        if(n>=1000000000) return f(n/1000000000)+" Billion"+f(n-1000000000*(n/1000000000));
        else if(n>=1000000) return f(n/1000000)+" Million"+f(n-1000000*(n/1000000));
        else if(n>=1000) return f(n/1000)+" Thousand"+f(n-1000*(n/1000));
        else if(n>=100) return f(n/100)+" Hundred"+f(n-100*(n/100));
        else if(n>=20) return string(" ")+a_100[n/10-2]+f(n-10*(n/10));
        else if(n>=1) return string(" ")+a_20[n-1];
        else return "";
    }
};
const char * const Solution::a_20[]={"One", "Two", "Three", "Four","Five","Six","Seven","Eight","Nine","Ten", "Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
const char * const Solution::a_100[]={"Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
