package cn.leetcode.string;

public class $8_StringToIntegerAtoi {
    public int myAtoi(String s) {
        int n = s.length();
        char[] charArr = s.toCharArray();

        int index = 0;
        while (index < n && charArr[index] == ' ') {
            index++;
        }
        if (index == n) {
            return 0;
        }

        int sign = 1;
        if (charArr[index] == '+') {
            index++;
        } else if (charArr[index] == '-') {
            index++;
            sign = -1;
        }

        int res = 0;
        while (index < n) {
            char currChar = charArr[index];
            if (currChar > '9' || currChar < '0') {
                break;
            }

            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && (currChar - '0') > Integer.MAX_VALUE % 10)) {
                return Integer.MAX_VALUE;
            }
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && (currChar - '0') > -(Integer.MIN_VALUE % 10))) {
                return Integer.MIN_VALUE;
            }

            // 4.2 合法的情况下，才考虑转换，每一步都把符号位乘进去
            res = res * 10 + sign * (currChar - '0');
            index++;

        }
        return res;
    }
}
