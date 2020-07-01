package com.sunjinwei.tree.threaded03;

/**
 * 测试中序线索化
 * 1.输入一个结点 找到它的前驱结点和后继结点
 * 2.遍历中序线索化的二叉树
 */
public class ThreaderBinaryTreeDemo {
    public static void main(String[] args) {
        /**
         * 按照数组索引的顺序
         */
        // 创建结点对象
        HeroNode root = new HeroNode(1, "tom");
        HeroNode node2 = new HeroNode(3, "mary");
        HeroNode node3 = new HeroNode(6, "jack");
        HeroNode node4 = new HeroNode(8, "son");
        HeroNode node5 = new HeroNode(10, "json");
        HeroNode node6 = new HeroNode(14, "java");

        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);

        // 创建二叉树对象
        ThreaderBinaryTree threaderBinaryTree = new ThreaderBinaryTree(root);
        // 对二叉树进行中序线索化
        threaderBinaryTree.threadedNode(root);

        // 测试线索化之后 node5的前驱和后继结点
        System.out.println(node5.getLeft());
        System.out.println(node5.getRight());


        System.out.println("======线索化进行遍历");
        threaderBinaryTree.midThreadedList();


    }

}
