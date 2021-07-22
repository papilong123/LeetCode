package cn.example.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Stack;

class $20_ValidParentheses {

        private final HashMap<Character,Character> mappings;

        public $20_ValidParentheses(){
            this.mappings=new HashMap<Character,Character>();
            this.mappings.put(')','(');
            this.mappings.put(']','[');
            this.mappings.put('}','{');
        }

        public boolean isValid(String s){
            Stack<Character> stack=new Stack<Character>();
            for(int i=0;i<s.length();i++){
                char c=s.charAt(i);
                if(this.mappings.containsKey(c)){
                    char top=stack.empty()?'#':stack.pop();
                    if(top!=this.mappings.get(c))
                    return false;
                }else{
                    stack.push(c);
                }
            }
            return stack.empty();
        }

        public boolean $20_ValidParentheses2(String s){
            char[] array = s.toCharArray();
            Deque<Character> q = new ArrayDeque<>();
            for (int i = 0; i < s.length(); i++){
                if(array[i] =='(' || array[i] =='[' || array[i] =='{'){
                    q.addLast(array[i]);
                }else{
                    if(array[i] == ')'){
                        if(q.size() > 0 &&'(' == q.pollLast()){
                            continue;
                        }else{
                            return false;
                        }
                    }else if(q.size() > 0 && array[i] == ']'){
                        if('[' == q.pollLast()){
                            continue;
                        }else{
                            return false;
                        }
                    }else if(q.size() > 0 && array[i] == '}'){
                        if('{' == q.pollLast()){
                            continue;
                        }else{
                            return false;
                        }
                    }
                }
            }
            return q.size() == 0 && array.length % 2 != 1;
        }
}
