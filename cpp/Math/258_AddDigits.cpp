class Solution {
public:
    int addDigits(int num) {
        if(num%9==0 && num!=0)
            num=9;
        else
            num%=9;
            
        return num;
    }
};
