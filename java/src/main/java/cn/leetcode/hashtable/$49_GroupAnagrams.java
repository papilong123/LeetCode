package cn.leetcode.hashtable;

import java.util.*;

public class $49_GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> hashMap = new HashMap<>();
        for (String s : strs) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String str = new String(charArray);
            List<String> arr = hashMap.getOrDefault(str, new ArrayList<>());
            arr.add(s);
            hashMap.put(str, arr);
        }
        return new ArrayList<List<String>>(hashMap.values());
    }
}
