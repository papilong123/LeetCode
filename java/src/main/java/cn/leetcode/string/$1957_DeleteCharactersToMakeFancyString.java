package cn.leetcode.string;

public class $1957_DeleteCharactersToMakeFancyString {
    public String makeFancyString(String s) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++){
            if (res.length() >= 2 && res.charAt(res.length() - 2) == res.charAt(res.length() - 1) && s.charAt(i) == res.charAt(res.length() - 1)) {
                continue;
            }
            res.append(s.charAt(i));
        }
        return res.toString();
    }
}
