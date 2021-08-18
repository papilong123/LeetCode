package cn.leetcode.binarysearch;

public class $69_Sqrtx {
    public int mySqrt(int x) {
        int i = 1, j = x, ans = -1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int ans = new $69_Sqrtx().mySqrt(2147395599);
        System.out.println(ans);
    }
}
