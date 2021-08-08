package cn.leetcode.cache;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 用栈去掉可匹配的括号，这样最终栈内只会剩下形如“]]][[[”格式的括号。接下来我们观察其中的规律
 * ][ 可调整为 []，交换次数为1
 * ]][[ 可调整为 [][] ,交换次数为1。因为中间的]][[不需要交换
 * ]]][[[ 可调整为 [[][]] ,交换次数为2。同样中间的]]][[[不需要交换
 * ]]]][[[[ 可调整为 [[]][[]] ,交换次数为2。因为中间的]]]][[[[不需要交换
 *
 * 通过对规律的观察，可以得到，对应的结果应当为栈的长度除4，并向上取整。即 (stack.size() + 3) / 4
 */
public class $5840_N {
    public int minSwaps(String s) {
        Deque<Character> stack = new LinkedList<>();
        for(char c : s.toCharArray()){
            if(c == '['){
                stack.push('[');
            }else{
                if(!stack.isEmpty() && stack.peek() == '['){
                    stack.pop();
                }else{
                    stack.push(c);
                }
            }
        }

        return (stack.size()+3)/4;
    }

    public static void main(String[] args) {
        int ans = new $5840_N().minSwaps("[][[[]]][[][]]");
        System.out.println(ans);
    }
}
