class Solution {
public:
    int fib(int n) {
        int f0=0,f1=1,sum;
        for(int i=0;i<n;++i){
            sum=(f0+f1)%1000000007;
            f0=f1;
            f1=sum;
        }
        return f0;
    }
};
