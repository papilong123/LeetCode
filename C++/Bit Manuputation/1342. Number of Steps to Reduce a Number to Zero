class Solution {
public:
    int numberOfSteps (int num) {
        int res=0;
        while(num>0){
            if((num&1)==0){//num为偶数
                num >>= 1;
            }else{        //num为奇数
                num &= ~1;//等价于 num ^= 1
            }
        res++;            //记录步数
        }
        return res;
    }
};


int numberOfSteps1(int num) {
    if(num == 0) 
        return 0;
    if((num & 1) == 0) { // num为偶数
        return numberOfSteps1(num >>> 1) + 1;
    }
    else {               // num为奇数       
        return numberOfSteps1(num - 1) + 1;
    }
}
