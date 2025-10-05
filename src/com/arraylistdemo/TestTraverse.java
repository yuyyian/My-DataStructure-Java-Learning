package com.arraylistdemo;

import java.util.ArrayList;
import java.util.Iterator;

public class TestTraverse {
    public static void main(String[] args) {
        //通过下标来遍历
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        for (int i = 0 ; i < list.size() ; i++){
            System.out.println(list.get(i));
        }

        //通过foreach来遍历 本质上是迭代器的简化版本
        for (Integer num : list){
            System.out.println(num);
        }

        //通过迭代器的方式来遍历
        Iterator<Integer> integerIterator = list.iterator();
        while (integerIterator.hasNext()){
            //通过next获取下一个元素
            //通过hasNext判定遍历是否结束
            System.out.println(integerIterator.next());
        }

    }
}
