package cn.leetcode.math;

public class $7_ReverseInteger {
    public int reverse(int x) {
        int ans = 0,remain = 0;
        while(x != 0){
            remain = x % 10;

            if (ans>214748364 || (ans==214748364 && remain>7)) {
                return 0;
            }
            //判断是否 小于 最小32位整数
            if (ans<-214748364 || (ans==-214748364 && remain<-8)) {
                return 0;
            }
            ans = ans*10 + remain;

            x = x/10;
        }
        return ans;
    }
}
