package com.stack_queue.stack;

import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        //使用标准库中的栈
        Stack<String> stack = new Stack<>();

        //入栈
        stack.push("aaa");
        stack.push("bbb");
        stack.push("ccc");
        stack.push("ddd");
        //若没有入栈 直接进行出栈和取栈顶元素 会报出EmptyStackException异常

        //取栈顶元素(只是查看 不会把元素出栈)
        String top = stack.peek();
        System.out.println(top);

        //出栈 会返回出栈元素
        String s = stack.pop();
        System.out.println(s);
        s = stack.pop();
        System.out.println(s);
        s = stack.pop();
        System.out.println(s);
        s = stack.pop();
        System.out.println(s);

    }
}
