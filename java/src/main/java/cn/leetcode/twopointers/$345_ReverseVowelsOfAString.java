package cn.leetcode.twopointers;

public class $345_ReverseVowelsOfAString {
    public String reverseVowels(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        int i = 0, j = n - 1;
        while (i < j) {
            while (i < n && isNotVowel(arr[i])) {
                ++i;
            }
            while (j > 0 && isNotVowel(arr[j])) {
                --j;
            }
            if (i < j) {
                swap(arr, i++, j--);
            }
        }
        return new String(arr);
    }

    public boolean isNotVowel(char ch) {
        return "aeiouAEIOU".indexOf(ch) < 0;
    }

    public void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        String ans = new $345_ReverseVowelsOfAString().reverseVowels("hello");
        System.out.println(ans);
    }
}
