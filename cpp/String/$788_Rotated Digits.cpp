class Solution {
public:
    int rotatedDigits(int N) {
        int num[N+1];
        int count=0;
        for(int i=0;i<N+1;i++){
            if(i<10){
                if(i==0||i==1||i==8){
                    num[i]=1;
                }else if(i==2||i==5||i==6||i==9){
                    num[i]=2;
                    count++;
                }else{
                    num[i]=0;
                }
            }else{
                int a=i/10,b=i%10;
                if(num[a]==1 && num[b]==1){
                    num[i]=1;
                }else if(num[a]>=1 && num[b]>=1){
                    num[i]=2;
                    count++;
                }else{
                    num[i]=0;
                }
            }
        }
        return count;
    }
};
