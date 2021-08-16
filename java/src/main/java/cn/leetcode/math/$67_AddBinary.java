package cn.leetcode.math;

public class $67_AddBinary {
    public String addBinary(String a, String b) {
        int carry = 0;
        char[] charArrayA = a.toCharArray();
        char[] charArrayB = b.toCharArray();
        StringBuilder str = new StringBuilder();
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0 || carry == 1; i--, j--) {
            int k1 = i <= -1 ? 0 : charArrayA[i] - '0';
            int k2 = j <= -1 ? 0 : charArrayB[j] - '0';
            int sum = k1 + k2 + carry;
            int re = sum % 2;
            carry = sum / 2;
            str.append(re);
        }
        return str.reverse().toString();
    }

    public static void main(String[] args) {
        String ans = new $67_AddBinary().addBinary("11", "1");
        System.out.println(ans);
    }
}
