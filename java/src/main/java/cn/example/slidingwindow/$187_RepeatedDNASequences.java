package cn.example.slidingwindow;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 利用位运算实现滑动窗口，适用与元素种类比较少的情况
 */
public class $187_RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<Integer> set = new HashSet<>();
        Set<String> res = new HashSet<>();
        if(s.length() < 10){
            return new ArrayList<String>();
        }

        int window = 0;
        // 把字符串映射为二进制序列
        char[] map = new char[26];
        map['A' - 'A'] = 0;
        map['C' - 'A'] = 1;
        map['G' - 'A'] = 2;
        map['T' - 'A'] = 3;
        // 初始化第一组滑动窗口，位运算可以写在一行内
        for (int i = 0; i < 10; i++){
            window <<= 2;
            window |= map[s.charAt(i) - 'A'];
        }
        set.add(window);
        for (int i = 10; i < s.length(); i++){
            window <<= 2;
            window |= map[s.charAt(i) - 'A'];
            window &= 0xfffff;
            if(set.contains(window)){
                res.add(s.substring(i-9, i+1));
            }else{
                set.add(window);
            }
        }
        return new ArrayList<>(res);
    }

    /**
     * 第二种解法,利用ACGT最低3位不同
     * @param s string
     * @return List<String>
     */
    public List<String> findRepeatedDnaSequences2(String s) {
        Set<Integer> set = new HashSet<>();
        Set<String> res = new HashSet<>();
        if(s.length() < 10){
            return new ArrayList<String>();
        }

        int window = 0;

        char[] array = s.toCharArray();
        // 初始化第一组滑动窗口，位运算可以写在一行内
        for (int i = 0; i < 10; i++){
            window <<= 3;
            window |= (array[i] & 7);
        }
        set.add(window);
        for (int i = 10; i < s.length(); i++){
            window <<= 3;
            window |= (array[i] & 7);
            window &= 0x3fffffff;
            if(set.contains(window)){
                res.add(s.substring(i-9, i+1));
            }else{
                set.add(window);
            }
        }
        return new ArrayList<>(res);
    }
}
