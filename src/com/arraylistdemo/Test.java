package com.arraylistdemo;
//list -> "线性表"(interface继承自collection)
//里面的元素排列成一条线
//典型实现:Vector(old,不建议使用) ArrayList LinkedList
//前两个是连续储存空间 -> "顺序表" ->是通用的数据结构;
// (数组不是顺序表,没有增删改查的功能,只有[],.length|| ArrayList是数组的进一步的增删改查)
//最后一个是离散储存空间 -> "链表"


//所有集合类都是在java.util包中
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        //创建了一个空的ArrayList 没有保存任何元素;
        ArrayList<Integer> arrayList = new ArrayList<>();

        ArrayList<Integer> arrayList1 = null;
        //"向上转型'!!!,常见用法;
        List<Integer> arrayList2 = new ArrayList<>();

        //通过构造方法的参数,来指定顺序表的初始容量
        ArrayList<Integer> arrayList3 = new ArrayList<>(10);

    }
}
