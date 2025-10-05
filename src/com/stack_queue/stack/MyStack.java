package com.stack_queue.stack;
//模拟实现栈
//可以基于顺序表(数组)或者链表来实现
//基于数组更简单
public class MyStack {
    private String[] arr;
    private int size;

    public MyStack(){
        arr = new String[1000];
        size = 0;
    }
    public MyStack(int capacity){
        arr = new String[capacity];
        size = 0;
    }

    public void resize(){
        String[] newArr = new String[arr.length + (arr.length >> 1)];
        for(int i =0 ; i < size ; i++){
            newArr[i] = arr[i];
        }
        arr = newArr;
    }


    //入栈
    public void push(String elem){
        //实现一个尾插操作
        if(size == arr.length){
            resize();
        }
        arr[size] = elem;
        size++;
    }

    //出栈
    public String pop(){
        if(size == 0){
            throw new RuntimeException("Stack is Empty!");
        }
        //取出元素
        String elem = arr[size-1];
        size--;
        return elem;
    }

    //取栈顶元素
    public String peek(){
        if(size == 0){
            throw new RuntimeException("Stack is Empty!");
        }
        return arr[size-1];
    }
}
