package cn.leetcode.twopointers;

public class $443_StringCompression {
    public int compress(char[] chars) {
        int len = chars.length, i, j = 0, left = 0;
        for (i = 0; i < len; i++) {
            if (i == len - 1 || chars[i] != chars[i + 1]) {
                chars[j++] = chars[i];
                int num = i - left + 1;
                if (num > 1) {
                    int anchor = j;
                    while (num > 0) {
                        chars[j++] = (char) (num % 10 + '0');
                        num /= 10;
                    }
                    reverse(chars, anchor, j - 1);
                }
                left = i + 1;
            }
        }
        return j;
    }

    private void reverse(char[] chars, int i, int j) {
        while (i < j) {
            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        char[] chars = new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        int res = new $443_StringCompression().compress(chars);
        System.out.println(res);
    }
}
