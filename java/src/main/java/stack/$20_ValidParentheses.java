package stack;

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
}