package cn.example.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class $76_MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        String res = null;
        int counter = 0, min_len = Integer.MAX_VALUE, start = 0, end = 0;
        Map<Character, Integer> hashmap = new HashMap<>();
        for(int i = 0; i < t.length(); i++){
            hashmap.put(t.charAt(i), 1);
        }

        while (end < s.length()){
            if(hashmap.getOrDefault(s.charAt(end), 0) > 0){
                counter --;  // 最长长度，所以是减一
            }
            hashmap.put(s.charAt(end), hashmap.getOrDefault(s.charAt(end), 0) - 1);
            end ++;
            while(counter == 0){
                if(end - start < min_len){
                    min_len = end -start;
                    res = s.substring(start, end);
                }
                if(hashmap.get(s.charAt(start)) > 0){
                    counter ++;
                }
                hashmap.put(s.charAt(start), hashmap.getOrDefault(s.charAt(start), 0) + 1);
                start ++;
            }
        }

        return res;
    }

}
