package cn.leetcode.backtrack.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class $17_LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if (digits.length() == 0) {
            return combinations;
        }

        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backtrack(combinations, phoneMap, digits, 0, new StringBuffer());
        return combinations;
    }

    public void backtrack(List<String> res, Map<Character, String> phoneMap, String digits, int index, StringBuffer path) {
        if (index == digits.length()) {
            res.add(path.toString());
            return;
        }
        char digit = digits.charAt(index);
        String letters = phoneMap.get(digit);
        int lettersCount = letters.length();
        for (int i = 0; i < lettersCount; i++) {  // 每个数字对应的所有字母
            path.append(letters.charAt(i));
            backtrack(res, phoneMap, digits, index + 1, path);
            path.deleteCharAt(index);
        }
    }

}
