package com.sunjinwei.tree.haffman05;

/**
 * 结点 实现排序接口 重写compareTo方法
 */
public class HaffManNode {
    // 结点的值也就是结点的权值
    private int value;

    // 左结点
    private HaffManNode left;

    // 右结点
    private HaffManNode right;

    public HaffManNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public HaffManNode getLeft() {
        return left;
    }

    public void setLeft(HaffManNode left) {
        this.left = left;
    }

    public HaffManNode getRight() {
        return right;
    }

    public void setRight(HaffManNode right) {
        this.right = right;
    }

    /**
     * 前序遍历
     *
     * @return
     */
    public void preOrder() {

        System.out.println(this);

        if (this.left != null) {
            this.left.preOrder();
        }

        if (this.right != null) {
            this.right.preOrder();
        }

    }


    @Override
    public String toString() {
        return "HaffManNode{" +
                "value=" + value +
                '}';
    }
}
