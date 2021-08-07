package cn.example.bitmanipulation;

public class $191_NumberOf1Bits {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int ans = 0;
        for(int i = 0; i < 32; i++){
            if((n & 1 << i) != 0){
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int ans = new $191_NumberOf1Bits().hammingWeight(25);
        System.out.println(ans);
    }
}
