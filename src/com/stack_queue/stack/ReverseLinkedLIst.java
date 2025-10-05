package com.stack_queue.stack;

import java.util.Stack;

public class ReverseLinkedLIst {
    static class Node{
        public String val;
        public Node next;

        public Node(String val){
            this.val = val;
            this.next =null;
        }
    }
    //反向打印单链表
    public static void reversePrint(Node head){
        //1.递归的写法 借助jvm自带的栈 后进先出的特点
//        if(head == null){
//            return;
//        }
//        reversePrint(head.next);
//        System.out.print(head.val+" ");

        //2.使用栈的写法
        if(head == null){
            return;
        }

        //创建栈,把栈的元素都入栈
        Stack<String> stack = new Stack<>();
        Node cur = head;
        for(; cur != null ; cur = cur.next){
            stack.push(cur.val);
        }
        while(!stack.isEmpty()){
            String s = stack.pop();
            System.out.print(s +" ");
        }
    }

    public static Node build(){
        Node a = new Node("a");
        Node b = new Node("b");
        Node c = new Node("c");
        Node d = new Node("d");
        a.next = b;
        b.next = c;
        c.next = d;
        return a;
    }

    public static void main(String[] args) {
        Node head = build();
        reversePrint(head);
    }
}
