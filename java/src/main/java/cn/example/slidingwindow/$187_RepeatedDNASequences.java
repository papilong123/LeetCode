package cn.example.slidingwindow;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class $187_RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        if(s.length() < 10){
            return res;
        }

        Set<Integer> set = new HashSet<>();
        int window = 0;
        char[] map = new char[26];
        map['A' - 'A'] = 0;
        map['C' - 'A'] = 1;
        map['G' - 'A'] = 2;
        map['T' - 'A'] = 3;
        for (int i = 0; i < 10; i++){
            window = window << 2 | map[s.charAt(i) - 'A'];
        }
        set.add(window);
        for (int i = 10; i < s.length(); i++){
            ;
        }
        return res;
    }
}
