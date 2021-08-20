class Solution {
public:
    bool Judgehuiwen(int left,int right,cn.example.string &str) {
        while (left < right) {
            if (str[left] != str[right]) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }

    bool validPalindrome(cn.example.string s){
        int left = 0,right = s.size() - 1;
        while (left < right) {
            if (s[left] != s[right]) {
                return (Judgehuiwen(left + 1, right, s)) || (Judgehuiwen(left, right - 1, s));
            } else {
                left++;
                right--;
            }
        }
        return true;
    }
};
