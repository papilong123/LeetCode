class MinStack {
public:
    /** initialize your data structure here. */
    cn.example.stack<int> stk;
    cn.example.stack<int> minstk;
    MinStack() {

    }

    void push(int x) {
        if(minstk.empty() || x<=minstk.top()) minstk.push(x);
        stk.push(x);
    }

    void pop() {
        if(stk.top()==minstk.top()) minstk.pop();
        stk.pop();
    }

    int top() {
        return stk.top();
    }

    int getMin() {
        return minstk.top();
    }
};

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack* obj = new MinStack();
 * obj->push(x);
 * obj->pop();
 * int param_3 = obj->top();
 * int param_4 = obj->getMin();
 */
