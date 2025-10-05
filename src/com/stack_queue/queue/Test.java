package com.stack_queue.queue;

import java.util.*;

//queue是一个接口Interface(Stack是一个类)
public class Test  {
    public static void main(String[] args) {
        //Queue<Integer> queue1 = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.remove());
        boolean a = queue.isEmpty();

        //若要判定队列是否为空,下面两种方法均可,其中isEmpty是Collection接口里的方法;
        if(queue.peek() == null){
            return;
        }
        if(queue.isEmpty()){
            return;
        }

        //创建一个基于数组的队列
        Queue<Integer> queue2 = new ArrayDeque<>();//基于数组实现的双端队列
        //可以理解成一个头尾相接的数组 (当tail在数组最后一位并不意味着队列满额 ,还能接着首部继续入队)
        //又称循环队列

    }
}
