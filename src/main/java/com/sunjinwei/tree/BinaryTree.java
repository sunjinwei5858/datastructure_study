package com.sunjinwei.tree;

/**
 * 二叉树对象
 * 其实只需要根结点即可
 * 如何触发遍历 通过二叉树的根结点触发就行
 * 1。三种方式遍历
 * 2。三种方式查找结点
 */
public class BinaryTree {
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    /**
     * 1.前序遍历 使用this调用
     */
    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("当前二叉树为空 无法遍历");
        }

    }

    /**
     * 2.中序遍历 使用this调用
     */
    public void middleOrder() {
        if (this.root != null) {
            this.root.middleOrder();
        } else {
            System.out.println("当前二叉树为空 无法遍历");
        }
    }

    /**
     * 3.后序遍历 使用this调用
     */
    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("当前二叉树为空 无法遍历");
        }
    }

    /**
     * 1 前序遍历查找
     */
    public HeroNode preSearch(Integer no) {
        if (this.root != null){
            return this.root.preSearch(no);
        }
        return null;
    }

    /**
     * 2 中序查找
     */
    public HeroNode middSearch(Integer no){
        if (this.root != null){
            return this.root.middSerach(no);
        }
        return null;
    }


}
