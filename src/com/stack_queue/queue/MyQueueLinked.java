package com.stack_queue.queue;
//基于单链表来实现队列
public class MyQueueLinked {
    static class Node{
        public String val;
        public Node next;
        public Node(String val){
            this.val = val;
            this.next = null;
        }
    }

    //把队列的头部和尾部都记录下来
    //基于链表实现队列:
    //常见如下 链表的头尾和队列的头尾是一致的
    //1.入队 -> 尾插
    //2.出队 -> 头删
    //Or 链表的头尾和队列的头尾是相反的
    //1.入队 -> 头插
    //2.出队 -> 尾删

    private Node head = null;
    private Node tail = null;

    //入队
    public void offer(String val){
        Node newNode = new Node(val);
        if(head == null){
            head = newNode;
            tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = tail.next;
    }
    //出队
    public String poll(){
        if(head == null){
            return null;
        }
        //需要保存头部节点的值当作返回值
        String val = head.val;
        head = head.next;
        if(head == null){
            tail = null;
        }
        return val;
    }
    //取队列首元素
    public String peek(){
        if(head == null){
            return null;
        }
        return head.val;
    }

    //判断是否为空
    public boolean isEmpty(){
        return head == null;
    }

    //队列大小
    public int size(){
        int size = 0;
        Node cur = head;
        for(; cur != null ; cur = cur.next){
            size++;
        }
        return size;
    }

    //测试
    public static void main(String[] args) {

    }
}
