package com.linkedList;
//对于链表来说 头节点是非常重要的
//因此习惯于用链表的异地个节点来代指整个链表 ->"借代"

//链表分为下面下面几种类型(正交的 可以相互组合)
//1.单向或双向

//2.带头不带头
//注意:更准确来说-> 是否带有傀儡节点
//头节点: 链表的第一个节点
//傀儡节点(dummy node): 不存储数据 只是用来占位子 从而简化后续代码的书写
//通常来说我们会将链表的第一个节点作为傀儡

//3.是否循环
//最后一个结点的next,指向null;==>不是循环的
//最后一个节点的next,指向第一个节点; ==> 是循环的


//重点关心 无头单向非循环链表(面试)  无头双向非循环链表(开发)

import java.util.Iterator;
import java.util.LinkedList;

public class Test {
    public static void main(String[] args) {
        LinkedList<Integer> list= new LinkedList<>();
        //相当于尾插
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        //头插
        list.add(0,4);
        list.addFirst(5);
        System.out.println(list);


        //通过内置类型 进行下标删除
        list.remove(2);
        //通过包装类 进行数值删除
        list.remove(Integer.valueOf(2));
        //头删和尾删
        list.removeFirst();
        list.removeLast();

        //通过get按照下标来修改元素
        //通过set按照下标来设置元素
        int elem = list.get(0);
        list.set(0,3);
        System.out.println(list);

        //通过contains查找 判定元素是否存在
        boolean contains = list.contains(3);
        System.out.println(contains);

        //清空
        list.clear();
        list.add(1);
        //迭代器来遍历整个链表
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }




    }
}
