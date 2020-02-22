class Solution {
public:
    int subtractProductAndSum(int n) {
        int i=n;
        int j=n;

        int mult=1;
        while(i!=0){
            int tmp=i%10;
            i/=10;
            mult*=tmp;
        }

        int plus=0;
        while(j!=0){
            int tmp=j%10;
            j/=10;
            plus+=tmp;
        }

        return mult-plus;
    }
};
