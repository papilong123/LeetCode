package cn.leetcode.stack;

import java.util.Stack;

class $232_ImplementQueueUsingStacks {

    private final Stack<Integer> s1;
    private final Stack<Integer> s2;

    /**
     * Initialize your data structure here.
     */
    public $232_ImplementQueueUsingStacks() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        s1.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (s2.empty()) {
            while (!s1.empty()) {
                s2.push(s1.pop());
            }
            if (s2.empty()) {
                return -1;
            } else {
                return s2.pop();
            }
        } else {
            return s2.pop();
        }
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (!s2.empty()) {
            return s2.peek();
        }else{
            while (!s1.empty()) {
                s2.push(s1.pop());
            }
            if (s2.empty()) {
                return -1;
            }else {
                return s2.peek();
            }
        }
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return s1.empty() && s2.empty();
    }

    public static void main(String[] args) {
        $232_ImplementQueueUsingStacks obj = new $232_ImplementQueueUsingStacks();
        obj.push(3);
        int param_2 = obj.pop();
        boolean param_4 = obj.empty();
        int param_3 = obj.peek();
    }

}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
