package cn.leetcode.twopointers;

public class $541_ReverseStringII {
    public String reverseStr(String s, int k) {
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < len; ) {
            int slow = i, fast = i;
            slow += (k - 1);
            fast += (2 * k - 1);
            if (i <= len - 1 && slow >= len - 1) {
                sb.append(s, i, len).reverse();
                res.append(sb);
                sb.setLength(0);
            } else if (slow < len - 1 && fast > len - 1) {
                sb.append(s, i, slow + 1).reverse();
                res.append(sb);
                res.append(s, slow + 1, len);
                sb.setLength(0);
                break;
            } else {
                sb.append(s, i, slow + 1).reverse();
                res.append(sb);
                res.append(s, slow + 1, fast + 1);
                sb.setLength(0);
            }
            i = fast + 1;
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String res = new $541_ReverseStringII().reverseStr("abcdefg", 2);
        System.out.println(res);
    }
}
