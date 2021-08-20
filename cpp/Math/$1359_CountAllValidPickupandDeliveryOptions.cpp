class Solution {
public:
    long long p=1;
    int countOrders(int n) {
        for(int i=2;i<=n;i++){
            long long a=2*(i-1)+1;
            long long b=a*(a-1)/2+a;
            p=(p*b)%1000000007;
        }
        return p;
    }
};
