package cn.example.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/solution/hua-dong-chuang-kou-by-powcai/
 */
public class $3_LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        int max = 0, counter = 0, left = 0, right = 0;
        Map<Character, Integer> hashmap = new HashMap<>();
        while(right < s.length()){
            if(hashmap.getOrDefault(s.charAt(right), 0) > 0){
                counter += 1;
            }
            hashmap.put(s.charAt(right), hashmap.getOrDefault(s.charAt(right),0)+1);
            right += 1;
            while(counter > 0){
                if(hashmap.get(s.charAt(left)) > 1){
                    counter -= 1;
                }
                hashmap.put(s.charAt(left), hashmap.getOrDefault(s.charAt(left),0)-1);
                left += 1;
            }
            max = Math.max(max, right - left);
        }

        return max;
    }

}
