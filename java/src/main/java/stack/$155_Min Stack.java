package stack;

import java.util.Stack;

class $155_MinStack {

    private Stack<Integer> data;
    private Stack<Integer> helper;

    /** initialize your data structure here. */
    public $155_MinStack() {
        data=new Stack<>();
        helper=new Stack<>();
    }

    public void push(int x) {
        data.add(x);
        if(helper.isEmpty()||helper.peek()>x){
            helper.add(x);
        }else{
            helper.add(helper.peek());
        }
    }

    public void pop() {
        if(!data.isEmpty()){
            data.pop();
            helper.pop();
        }
    }

    public int top() {
        if(!data.isEmpty()){
            return data.peek();
        }
        throw new RuntimeException("栈中元素为空，此操作非法");
    }

    public int getMin() {
        if(!data.isEmpty()){
            return helper.peek();
        }
        throw new RuntimeException("栈中元素为空，此操作非法");
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
