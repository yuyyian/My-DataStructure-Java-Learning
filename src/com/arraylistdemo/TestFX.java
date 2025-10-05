package com.arraylistdemo;

import java.util.ArrayList;
import java.util.List;

public class TestFX {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        //尾插
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println(list);
        //指定位置插入 (在下标之前插入)不能超出已有下标
        list.add(2,100);
        System.out.println(list);

        list.add(0,10);
        System.out.println(list);
        //插入一组
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list.addAll(list1);
        System.out.println(list);


        //按照下标删除   &  返回被删除的元素
        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        list2.add(2);
        list2.add(2);
        list2.add(2);
        list2.add(3);
        list2.add(4);
        int result = list2.remove(1);
        System.out.println(list2);


        //按照值来进行删除 & 返回是否删除成功
        boolean isRemoved = list2.remove(Integer.valueOf(1));
        System.out.println(list2);

        //若有多个相同的值 只删除第一个
        list2.remove(Integer.valueOf(2));
        System.out.println(list2);

        //删除多个元素
        List<Integer> toRemove = new ArrayList<>();
        toRemove.add(1);
        toRemove.add(2);
        toRemove.add(2);
        toRemove.add(2);
        toRemove.add(2);
        toRemove.add(2);
        list.removeAll(toRemove);
        System.out.println(list);

        //获得元素
        List<Integer> list3 = new ArrayList<>();
        list3.add(1);
        list3.add(2);
        list3.add(3);
        list3.add(4);
        list3.add(5);
        System.out.println(list3.get(0));
        //修改元素
        list3.set(0,2);
        System.out.println(list3);

        //清空
        list.clear();
        System.out.println(list);

        //查找数
        System.out.println(list2.contains(3));//返回是否找到
        System.out.println(list2.indexOf(3));//返回下标位置


        //取子集-> 前闭后开
        //sublist操作,并不是创建一个"副本",而是得到原始的list片段 修改sublist 也会影响到原list
        List<Integer> list4 = new ArrayList<>();
        list4.add(1);
        list4.add(1);
        list4.add(1);
        list4.add(1);
        list4.add(1);
        //System.out.println(list4.subList(1,4));
        List<Integer> sublist = list4.subList(1,4);
        sublist.set(0,100);
        System.out.println(sublist);
        System.out.println(list4);

        //获得元素个数
        System.out.println(list2.size());
        list2.add(2);
        System.out.println(list2.size());

    }




}
