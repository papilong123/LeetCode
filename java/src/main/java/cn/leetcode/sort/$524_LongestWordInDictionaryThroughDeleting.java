package cn.leetcode.sort;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class $524_LongestWordInDictionaryThroughDeleting {
    public String findLongestWord(String s, List<String> dictionary) {
        dictionary.sort((word1, word2) -> {
            if (word1.length() != word2.length()) {
                return word2.length() - word1.length();
            } else {
                return word1.compareTo(word2);
            }
        });
        for (String t : dictionary) {
            int i = 0, j = 0;
            while (i < t.length() && j < s.length()) {
                if (t.charAt(i) == s.charAt(j)) {
                    ++i;
                }
                ++j;
            }
            if (i == t.length()) {
                return t;
            }
        }
        return "";
    }

}
