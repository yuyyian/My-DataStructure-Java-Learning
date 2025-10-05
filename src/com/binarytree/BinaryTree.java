package com.binarytree;

import java.util.LinkedList;
import java.util.Queue;

//孩子表示法
//表示二叉树的一个节点
class Node{
    public String val;
    public Node left;//左子树
    public Node right;//右子树

    public Node(String val){
        this.val = val;
        left = null;
        right = null;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val='" + val + '\'' +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}

//可以通过一个根节点来表示整个树
//1.直接使用Node root表示
//2.创建一个新的类,在类中持有上述的Node root;
class Tree{
    public Node root;
}
public class BinaryTree {
    //创建树
    public static Node createTree(){
        //先创建所有节点
        Node a = new Node("a");
        Node b = new Node("b");
        Node c = new Node("c");
        Node d = new Node("d");
        Node e = new Node("e");

        //把这些节点连接起来
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        return a;
    }


    //树的遍历[非线性结构] ->把树的节点按照一定次序,全部访问一遍,做到"不重不漏"
    //问题的关键是约定好遍历的顺序
    //分为4种:先序遍历 中序遍历 后序遍历 层序遍历

    //先序遍历:基于递归
    //从根节点出发
    //1.先访问跟根节点的值(以打印为例,就是先去打印当前结点的值)
    //2.递归地-针对左子树-先序遍历
    //3.递归地-针对右子树-先序遍历

    //规律:第一个元素是根节点 且每个子树的第一个元素也是子树的根节点
    public static void preOrder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    //中序遍历:基于递归
    //从根结点出发
    //1.先去递归左子树
    //2.访问根节点
    //3.后递归右子树
    public static void inOrder(Node root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }
    //根节点左侧的元素属于左子树,右侧的元素属于右子树;(子树同上)

    //后序遍历:基于递归
    //1.先递归左子树
    //2.在递归右子树
    //3.访问根节点
    public static void postOrder(Node root){
        if(root == null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }
    //规律:最后一个元素是根节点 且每个子树的最后一个元素也是子树的根节点

    //层序遍历
    //按照层为维度,把每一层的元素都从左到右的访问出来
    //层序遍历的实现,需要搭配一个队列
    //1.创建一个队列,元素为Node,先把根节点入队列
    //2.循环的取出队首元素,访问这个元素的值
    //3.把这个元素的左子树和右子树分别入队列(非空)
    //4.回到2进行循环
    //5.如果队列为空,说明遍历结束了
    public static void levelOrder(Node root){
        if(root == null){
            return;
        }
        //创建一个队列
        Queue<Node> queue = new LinkedList<>();
        //把根节点添加到队列中
        queue.offer(root);

        while(!queue.isEmpty()){
            //1.取出队首元素
            Node cur = queue.poll();
            System.out.print(cur.val + " ");
            if(cur.left != null){
                queue.offer(cur.left);
            }
            if(cur.right != null){
                queue.offer(cur.right);
            }
        }
    }

    //获取元素个数

//    public static int size;//通过定义成员变量虽然可行 但在oj做题中容易出问题(多组输入)
//    public static int size(Node root){
//        //哪种遍历都行
//        if(root == null){
//            return 0;
//        }
////        int size = 0;//局部变量 每次进入一个方法栈都会创建新的size;不能用这个方式
//        size++;
//        size(root.left);
//        size(root.right);
//        return size;
//    }


    //最推荐的做法
    public static int size(Node root){
        if(root == null){
            return 0;
        }
        int rootSize = 1;
        int leftSize = size(root.left);
        int rightSize = size(root.right);
        return rootSize + leftSize + rightSize;
    }
    //换个角度来理解:
        //一棵树的size是由三个部分组合:
        //1.根节点的节点个数
        //2.左子树的节点个数
        //3.有子树的节点个数

    //优化写法 =>
//    public static int size(Node root){
//        if(root == null){
//            return 0;
//        }
//        return 1 + size(root.left) + size(root.right);
//    }


    //获取叶子节点个数
    //整棵树的叶子节点个数 = 左子树的叶子节点个数 + 右子树的叶子节点个数
    //除非根节点没有叶子个数,这个时候返回1(说明根节点是叶子节点)
    public static int getLeafSize(Node root){
        if(root == null){
            return 0;
        }
        //判定当前节点是否是叶子节点
        if(root.right == null && root.left == null){
            return 1;
        }
        return getLeafSize(root.left) + getLeafSize(root.right);
    }

    //获取第k层的节点个数
    //第k层的最大节点个数 2^(k - 1);
    //思路:分治思想
    //如果k < 1  非法输入
    //如果k = 1  求第一层节点个数 (如果是非空的树,节点个数就是1)
    //如果k > 1  把求k层节点个数转化为 => 求左子树k - 1层的节点个数 + 右子树k - 1的节点个数
    public static int getLevelNodeCount(Node root , int k){
        if(k < 1 || root == null){
            return 0;
        }
        if(k == 1){
            return 1;
        }
        return getLevelNodeCount(root.left , k -1) + getLevelNodeCount(root.right , k-1);
    }


    //获取二叉树的高度(根结点出发到任意,路径的最大长度)=>基于递归
    //思路:
    //求A树的高度 = max{B的高度,C的高度} + 1
    public static int getHeight(Node root){
        if(root == null){
            return 0;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }


    //检测值为value的元素是否存在
    public static Node find (Node root,String val){
        if(root == null){
            return null;
        }
        if(root.val.equals(val)){
            return root;
        }
        //递归查找左侧字数
        Node leftResult = find(root.left,val);
        if(leftResult != null){
            return leftResult;
        }
//        Node rightResult = find(root.right,val);
//        if(rightResult != null){
//            return rightResult;
//        }
//        return null;
        //也可以简化成
        return find(root.right,val);
    }


    //判断那一个树是不是完全二叉树
    //思路:按照两个阶段来判断是否属于
    //第一阶段中,任意一个访问到的节点,都应该有两个子树
    //如果遇到以下情况:
    //a)没有子树的节点,进入第二阶段
    //b)只有左子树的节点,进入第二阶段
    //c)只有柚右子树的节点,直接判定非二叉树
    //第二件段中,要求每个节点都没有子树
    //一旦遇到了有子树的节点,判定为非二叉树
    public static boolean isCompleteTree(Node root){
        if(root == null){
            //空树也可看作完全二叉树
            return true;
        }
        //通过这个变量来表示当前阶段是否是第一阶段
        boolean isFirstStep = true;
        //针对这棵树进行层序遍历
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            //此处的访问:对此节点进行判定
            if(isFirstStep){
                if(cur.left == null && cur.right == null){
                    //没有子树进入二阶段
                    isFirstStep = false;
                } else if(cur.left != null && cur.right == null){
                    //只有左子树进入二阶段
                    isFirstStep = false;
                    queue.offer(cur.left);
                } else if(cur.left == null && cur.right != null){
                    //只有右子树直接返回false
                    return false;
                } else{
                    //左右子树都有,继续向后遍历
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                }
            }else{
                //第二阶段的判定
                //要求所有的节点,必须是没有子树的
                if(cur.left != null || cur.right != null){
                    return false;
                }
                //若没有子树,也就意味着没有元素去入队列
            }
        }
        return true;
    }


    public static void main(String[] args) {
//        //1.root表示一棵树
//        Node root = new Node("A");
//
//        //2.Tree类也可以表示一棵树
//        Tree tree = new Tree();
//        tree.root = new Node("a");

        //简单粗暴构建一棵树
        Node root = createTree();
//        preOrder(root);
//        System.out.println();
//        inOrder(root);
//        System.out.println();
//        postOrder(root);
//        System.out.println();
//        levelOrder(root);
//        System.out.println();
//        System.out.println(size(root));
//        System.out.println(getLeafSize(root));
//        System.out.println(getLevelNodeCount(root,3));
//        System.out.println(getHeight(root));
//        System.out.println(find(root,"e"));
        System.out.println(isCompleteTree(root));
    }
}
