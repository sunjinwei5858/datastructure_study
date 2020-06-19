package com.sunjinwei.tree;

/**
 * 测试二叉树的遍历
 * 英雄人物
 * 1宋江 2吴用 3卢俊义 4林冲
 */
public class BinaryTreeDemo {
    public static void main(String[] args) {
        // 创建一棵树
        BinaryTree binaryTree = new BinaryTree();

        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "卢俊义");
        HeroNode node4 = new HeroNode(4, "林冲");

        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);

        binaryTree.setRoot(root);

        // 先手动创建二叉树 后续递归创建结点
        System.out.println("前序遍历");
        binaryTree.preOrder();
        System.out.println("中序遍历");
        binaryTree.middleOrder();
        System.out.println("后序遍历");
        binaryTree.postOrder();

        System.out.println("============");

        /**
         * 习题：3号结点卢俊义 增加一个左子结点【5 关胜】
         * 前中后序遍历输出顺序是什么
         */
        HeroNode node5 = new HeroNode(5, "关胜");
        node3.setLeft(node5);

        System.out.println("前序遍历");
        binaryTree.preOrder(); // 1 2 3 5 4
        System.out.println("中序遍历");
        binaryTree.middleOrder(); // 2 1 5 3 4
        System.out.println("后序遍历");
        binaryTree.postOrder(); // 2 5 4 3 1

        System.out.println("-----------------------开始进行查找");

        /**
         * 前序查找结点为 5 的关胜
         */
        //HeroNode result = binaryTree.preSearch(1);
        //System.out.println(result);

        /**
         * 中序查找结点为 5 的关胜
         */
        HeroNode result = binaryTree.middSearch(5);
        System.out.println(result);



    }
}
