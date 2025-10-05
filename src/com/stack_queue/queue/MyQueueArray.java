package com.stack_queue.queue;
//基于数组是实现队列
public class MyQueueArray {
    private String[] arr = null;
    //队首
    private int head = 0;
    //队尾
    private int tail = 0;
    //队列元素个数
    private int size = 0;

    public MyQueueArray(){
        arr = new String[1000];
    }

    public MyQueueArray(int capacity){
        arr = new String[capacity];
    }


    //入队
    public void offer(String val){
        if(size == arr.length){
            //也可以抛出异常 也可以扩容
            return;
        }
        arr[tail] = val;
        //更新tail指向
        tail++;
        if(tail == arr.length){
            tail = 0;//回到开头
        }
        //更新tail指向还有如下方法
        //tail = (tail + 1) % arr.length;

        size++;
    }

    //出队
    public String poll(){
        if(size == 0){
            return null;
        }
        //取出队首元素
        String val = arr[head];
        head++;
        if(head == arr.length){
            head = 0;
        }
        size--;
        return val;
    }

    //取队列首元素
    public String peek(){
        if(size == 0){
            return null;
        }
        return arr[head];
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public static void main(String[] args) {
        MyQueueArray queueArray = new MyQueueArray();
        queueArray.offer("1");
        queueArray.offer("2");
        queueArray.offer("3");
        queueArray.offer("4");
        queueArray.offer("5");
        System.out.println(queueArray.peek());
        System.out.println(queueArray.poll());
        System.out.println(queueArray.poll());
        System.out.println(queueArray.poll());
        System.out.println(queueArray.poll());
        System.out.println(queueArray.poll());
        System.out.println(queueArray.poll());
        System.out.println(queueArray.isEmpty());
    }
}
