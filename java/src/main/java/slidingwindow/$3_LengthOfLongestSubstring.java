package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class $3_LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        int max = 0, counter = 0, left = 0, right = 0;
        Map<Character, Integer> hashmap = new HashMap<>();

        while(right < s.length()){
            if(hashmap.containsKey(s.charAt(right))){
                counter += 1;
            }
            hashmap.put(s.charAt(right), hashmap.getOrDefault(s.charAt(right),0)+1);
            right += 1;
            while(counter > 0){

            }
            hashmap.put(s.charAt(right), right);
            max = Math.max(max, counter);
        }

        return max;
    }
}
