package com.arraylistdemo;
//只保存String类型的ArrayList

import java.security.DrbgParameters;

public class MyArrayList {
    private String[] date = null;
    private int size = 0;

    public MyArrayList(){
        date = new String[10];
    }

    public MyArrayList(int capacity){
        if(capacity <= 10){
            capacity = 10;
        }
        date = new String[capacity];
    }
    private void resize(){
        //创建一个更长的数组 1.5倍
        String[] newDate = new String[date.length + (date.length >> 1) ];
        //旧数组赋值到新数组上
        for (int i = 0 ; i < size ; i++){
            newDate[i] = date[i];
        }
        //新数组代替旧数组
        date = newDate;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0 ; i < size  ; i++){
            stringBuilder.append(date[i]);
            if (i < size - 1){
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();//为满足返回值类型
    }

    //实现尾插操作
    //时间复杂度O(1)
    public void add(String elem){
        //[0,size)区间是有效元素
        //需要实现扩容逻辑
        if(size >= date.length){
            resize();
        }
        date[size] = elem;
        size++;
    }

    //实现中间插入
    //时间复杂度O(N)
    public void add(int index , String elem){
        //当index==size 的时候 就相当于尾插一个数字
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("Index:" + index + "Size:" +size);
        }
        if (size >= date.length){
            resize();
        }
        //把元素放到位置上 从后往前移动
        for (int i = size - 1 ; i >= index ; i-- ){
            date[i + 1] = date[i];
        }
        date[index] = elem;
        size++;
    }

    //实现删除操作
    //时间复杂度O(N)
    public String remove(int index){
        if( index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        String elem = date[index];
        for (int i = index ; i < size - 1 ; i++){
            date[i] = date[i+1];
        }
        size--;
        return elem;
    }

    //实现删除值操作
    //时间复杂度O(N)

    public boolean remove(String elem){
        //找位置再搬运
        int deletePose = 0;
        for (deletePose = 0 ; deletePose < size ; deletePose++){
            if(date[deletePose].equals(elem)){
                break;
            }
        }
        if(deletePose == size){
            return false;
        }
        for(int i = deletePose ; i < size - 1 ; i++){
            date[i] = date[i+1];
        }
        size--;
        //remove(deletePose);
        return true;
    }
    //时间复杂度O(1)

    public String get(int index){
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        return date[index];
    }
    //时间复杂度O(1)

    public void set(int index , String elem){
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        date[index] = elem;
    }
    //时间复杂度O(1)

    public void clear(){
        size = 0;
    }

    //时间复杂度O(N)
    public boolean contains( String elem ){
        for (int i = 0 ; i < size ; i++){
            if (date[i].equals(elem)){
                return true;
            }
        }
        return false;
        //或者复用indexOf
        //return indexOf(elem) != -1
    }

    //时间复杂度O(N)
    public int indexOf(String elem){
        for (int i = 0 ; i < size ; i++){
            if (date[i].equals(elem)){
                return i;
            }
        }
        return -1;
    }
    //时间复杂度O(N)
    public int lastIndexOf(String elem){
        for (int i = size -1 ; i >= 0 ; i--){
            if (date[i].equals(elem)){
                return i;
            }
        }
        return -1;
    }
    //时间复杂度O(N)
    public MyArrayList subList(int fromIndex , int toIndex){
        if(fromIndex < 0 || toIndex > size || fromIndex >= toIndex){
            throw new IndexOutOfBoundsException();
        }
        MyArrayList subList = new MyArrayList(toIndex - fromIndex);//容量可计算 前闭后开可以直接获得size
        for(int i = fromIndex ; i < toIndex ; i++){
            String elem = get(i);
            subList.add(elem);
        }
        return subList;

    }
    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add("hello");
        myArrayList.add("world");
        System.out.println(myArrayList);
    }
}


//顺序表擅长两方面
//1.尾插
//2.根据下标 获取或者修改元素


//局限性
//1.空间利用率较低
//2.中间位置插入删除,需要进行搬运
//为了解决上述问题 引入链表