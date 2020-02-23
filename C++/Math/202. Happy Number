class Solution {
public:
    bool isHappy(int n) {
        int slow=n,fast=n;

        do{
            slow=helper(slow);
            fast=helper(fast);
            fast=helper(fast);
        }while(slow!=fast);
        
        return slow==1;
    }

    int helper(int n){//一次操作
        int num=0;
        while(n>0){
            num+=(n%10)*(n%10);
            n/=10;
        }
        return num;
    }
};
