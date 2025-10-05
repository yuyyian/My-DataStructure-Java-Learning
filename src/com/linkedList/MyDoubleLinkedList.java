package com.linkedList;
//双向列表的节点

public class MyDoubleLinkedList {
    static class Node{//如果不加static Node就会依赖MyDoubleLinkedList的this
        public String val;
        public Node pre;
        public Node next;
        public Node(String val){
            this.val = val;
            this.pre = null;
            this.next = null;
        }
    }//内部类是为了和别的包区分同名类

    //表示整个链表,此处没有引入傀儡节点，使用null表示空节点

    private Node head = null;
    //使用tail是为了简化尾插操作
    private Node tail = null;

    public int size(Node head){
        int size = 0;
        for (Node cur = head ; cur != null ; cur = cur.next){
            size++;
        }
        return size;
    }
    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for(Node cur = head ; cur != null ; cur = cur.next){
            stringBuilder.append(cur.val);
            if(cur.next != null){
                stringBuilder.append(",");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    //实现链表的核心操作
    public void addFirst(String val){
        Node newNode = new Node(val);
        if(head == null){
            head = newNode;
            tail = newNode;
            head.pre = null;
            tail.next = null;
        }else{
            //建立新节点和原来头结点的关系
            newNode.next = head;
            head.pre = newNode;
            //head指向新节点
            head = newNode;
        }
    }
    //尾插
    public void addLast(String val){
        Node newNode = new Node(val);
        if(head == null){
            head = newNode;
            tail = newNode;
            head.pre = null;
            tail.next = null;
        }
        tail.next = newNode;
        newNode.pre = tail;
        tail = newNode;
    }

    //中间任意位置插入，index
    public void add(int index , String val){
        Node newNode = new Node(val);
        int size = size(head);
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }
        Node cur = head;
        if(head == null){
            addLast(val);
            return;
        }
        if(index == size){
            addLast(val);
            return;
        }
        for(int i = 0 ; i < index ; i++){
            cur = cur.next;
        }
        newNode.pre = cur.pre;
        newNode.next = cur;
        cur.pre.next = newNode;
        cur.pre=newNode;
    }

    //删除
    //删除头部
    public void removeFirst(){
        if(head == null){
            return;
        }
        if(head == tail){
            head = null;
            tail = null;
            return;
        }
        Node oldhead = head;
        head = head.next;
        head.pre = null;
        oldhead.next = null;
    }


    //删除尾部
    public void removeLast(){
        if(head == null){
            return;
        }
        if(head == tail){
            head = null;
            return;
        }
        Node oldTail = tail;
        tail = tail.pre;
        tail.next = null;
        oldTail.pre = null;
    }

    //删除中间位置
    public void remove(int index){
        if(head == null){
            throw new IndexOutOfBoundsException();
        }
        int size = size(head);
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        if(index == 0){
            removeFirst();
            return;
        }
        if(index == size - 1){
            removeLast();
            return;
        }
        Node cur = head;
        for(int i = 0 ; i < index ; i++){
            cur = cur.next;
        }
        cur.pre.next = cur.next;
        cur.next.pre =  cur.pre;
        cur.pre = null;
        cur.next = null;
    }

    //删除指定值
    public void removeVal(String val){
        if(head == null){
            return;
        }
        Node cur = head;
        boolean isFind = false;
        for(; cur != null ; cur = cur.next){
            if(cur.val.equals(val)){
                isFind = true;
                break;
            }
        }
        if(!isFind){
            return;
        }
        if(head.next == null){
            removeFirst();
        }
        if(cur.next == null){
            removeLast();
        }
        cur.pre.next = cur.next;
        cur.next.pre = cur.pre;
        cur.pre = null;
        cur.next = null;

    }



    //判定元素是否存在
    public boolean contains(String val){
        for(Node cur = head ; cur != null ;cur = cur.next){
            if(cur.val.equals(val)){
                return true;
            }
        }
        return false;
    }
    //
    public int indexOf(String val){
        int index = 0;
        for(Node cur =head ; cur != null ; cur = cur.next){
            if(cur.val.equals(val)){
                return index;
            }
            index++;
        }
        return -1;
    }

    public void clear(){
        head = null;
        tail = null;
    }

    //测试用例
    public static void  test1(){
        MyDoubleLinkedList list = new MyDoubleLinkedList();
        list.addFirst("h");
        list.addFirst("e");
        list.addFirst("l");
        list.addFirst("l");
        list.addFirst("o");
        System.out.println(list);
    }

    public static void test2(){
        MyDoubleLinkedList list = new MyDoubleLinkedList();
        list.addLast("h");
        list.addLast("e");
        list.addLast("l");
        list.addLast("l");
        list.addLast("o");
        System.out.println(list);
    }





    public static void main(String[] args) {
        //test1();
        //test2();
    }

}
