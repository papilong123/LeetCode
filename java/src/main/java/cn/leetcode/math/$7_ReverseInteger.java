package cn.leetcode.math;

public class $7_ReverseInteger {
    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            // 其实判断条件可以简化的，因为x本身会被int限制，当x为正数并且位数和Integer.MAX_VALUE的位数相等时首位最大只能为2，
            // 所以逆转后不会出现res = Integer.MAX_VALUE / 10 && tmp > 2的情况，
            // 自然也不需要判断res==214748364 && tmp>7了，反之负数情况也一样
            if (res < Integer.MIN_VALUE / 10 || res > Integer.MAX_VALUE / 10) {
                return 0;
            }
            res = res * 10 + x % 10;
            x /= 10;
        }
        return res;
    }
}
