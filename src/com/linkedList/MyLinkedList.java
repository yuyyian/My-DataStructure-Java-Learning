package com.linkedList;
//表示链表的一个节点
//模拟实现String类型的链表
//设成public 可以省略getter setter方法 简化代码
class Node{
    public String value;
    //节点的下一个元素
    public Node next;

    public Node(String value){
        this.value = value;
        this.next = null;
    }
}
public class MyLinkedList {
    //把链表的头节点表示出来 就可以获取到整个链表

    //此处不包含傀儡节点 当head = null时 表示一个空的链表
    private Node head = null;
    //链表不需要size表示有效元素 可加可不加

    //插入元素=>尾插\头插\指定位置插入

    public void addLast(String value){
        //先找到链表的尾巴 再把新节点加到尾巴的后面
        Node newnode = new Node(value);
        //考虑链表是空链表
        if(head == null){
            head = newnode;
            return;
        }
        Node tail = head;
        for(; true/*tail.next != null*/; tail = tail.next){
            if(tail.next == null){
                break;
            }
        }
        tail.next = newnode;
    }

    public int size(){
        int size = 0;
        for (Node cur = head ; cur.next != null ; cur = cur.next){
            size++;
        }
        return size;
    }
    public String toString(){
        //通过这方法遍历链表
        //遍历的时候需要从头开始
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('[');
        for(Node cur = head ; cur != null ; cur = cur.next ){
            stringBuilder.append(cur.value);
            if(cur.next != null){
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public void addFirst(String value){
        //直接就能操作
        Node newNode = new Node(value);
        //把新结点放在头位置上;
        //1.让新节点的next指向原来的头节点
        //2.让head指向新的节点
        newNode.next = head;
        head = newNode;
    }

    public void add(int index , String value){
        //链表本身没有下标这个概念的 所以需要遍历来找到相应的位置 所以时间复杂度为O(N)
        //但java是例外 其本身的LinkedList也引入了"下标"个概念

        //1.判断index是否合法->非常重要
        if (index < 0 || index > size()){//若index==size 表示尾插
            throw new IndexOutOfBoundsException();
        }
        //2.根据value创建新节点
        Node newNode = new Node(value);

        //3.找到index 要插入位置的前一个结点
        //   单向列表只能找到next

        //针对头插的特殊处理
        if (index == 0){
            newNode.next = head;
            head = newNode;
            return;
        }

        Node prev = head;
        for (int i = 0 ; i < index -1 ;i++){
            //当 index = 1 时：需要插入到第 1 个位置，前一个节点是 index=0 的节点，只需移动 0 次（i < 0 不成立，循环不执行，prev 仍指向 head）。
            //当 index = 2 时：需要插入到第 2 个位置，前一个节点是 index=1 的节点，需移动 1 次（i=0 时循环执行 1 次）。
            //当 index = n 时：需要插入到第 n 个位置，前一个节点是 index=n-1 的节点，需移动 n-1 次。
            prev = prev.next;
        }
        //通过上述循环 让prev指向 index -1 的位置
        newNode.next = prev.next;
        prev.next = newNode;
    }


    //判定某个元素是否在链表中被包含
    public boolean contains(String value){
        for(Node cur = head ; cur != null ; cur = cur.next){//cur.next != null;会漏掉最后一个元素
            if(cur.value.equals(value)){
                return true;
            }
        }
        return false;
    }

    public int indexOf(String value){
        int index = 0;
        for(Node cur = head ; cur != null ; cur = cur.next){
            if(cur.value.equals(value)){
                return index;
            }
            index++;
        }
        return -1;
    }

    //删除列表的元素
    //按照下标来删除
    public void remove(int index){
        if(index < 0 || index >= size()){
            throw new IndexOutOfBoundsException();
        }
        if(index == 0){
            head = head.next;
            return;
        }
        //找到被删除元素的前一个结点
        Node prev = head;
        for(int i = 0 ; i < index -1 ; i++){
            prev = prev.next;
        }
        //找到被删除元素的后一个节点
        prev.next = prev.next.next;
    }

    //按照值来删除
    public void remove(String value){
        if(head == null){
            return;
        }
        //如果删除元素是head
        if(head.value.equals(value)){
            head = head.next;
            return;
        }
        //根据value值 找到待删除元素的前一个位置
        Node prev = head;
        for(; prev != null ; prev = prev.next){
            if(prev.next != null && prev.next.value.equals(value)){//前面进行空指针判定 是为了后续.next不会抛出IndexOutOfBoundException
                break;
            }
        }
        //通过循环prev 指向了带删除元素的前一个位置
        //注意上述循环的结束有两种情况
        if(prev == null){
            return;
        }
        //进行删除
        Node toRemove = prev.next;
        prev.next = toRemove.next;
    }

    public void clear(){
        head = null;//head原来指向的所有
    }
    private static void test1(){
        MyLinkedList list = new MyLinkedList();
        list.addFirst("h");
        list.addFirst("e");
        list.addFirst("l");
        list.addFirst("o");
        //需要遍历列表来检查是否正确
        System.out.println(list);
    }


    private static void test2(){
        MyLinkedList list = new MyLinkedList();
        list.addLast("a");
        list.addLast("b");
        list.addLast("c");
        list.addLast("d");
        list.addLast("e");
        System.out.println(list);
    }

    private static void test3(){
        MyLinkedList list = new MyLinkedList();
        list.addLast("h");
        list.addLast("e");
        list.addLast("l");
        list.addLast("l");
        list.addLast("o");
        list.add(2,"two");
        System.out.println(list);
    }


    public static void main(String[] args) {
        //test1();
        //test2();
        //test3();
    }
}

