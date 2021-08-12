package cn.leetcode.math;

public class $233_NumberOfDigitOne {
    public int countDigitOne(int n) {
        int ans = 0;
        int mulk = 1;
        while (mulk <= n) {
            ans += (n / (mulk * 10)) * mulk + Math.min(Math.max(n % (mulk * 10) - mulk + 1, 0), 100);
            mulk *= 10;
        }
        return ans;
    }
}
