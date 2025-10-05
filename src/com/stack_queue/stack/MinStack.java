package com.stack_queue.stack;

import java.util.Stack;


class MinStack {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public MinStack() {
        //不需要
    }

    public void push(int val) {
        stack1.push(val);
        if(stack1.isEmpty()){
            stack1.push(val);
            return;
        }
        int min = stack2.peek();
        if(val < min){
            stack2.push(val);
        }else{
            stack2.push(min);
        }
    }

    public void pop() {
        if(stack1.isEmpty()){
            return;
        }
        stack1.pop();
        stack2.pop();
    }

    public int top() {
        if(stack1.isEmpty()){
            return 0;
        }
        return stack1.peek();
    }

    public int getMin() {
        if(stack2.isEmpty()){
            return 0;
        }
        return stack2.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
