package com.sunjinwei.tree.binarysort;

/**
 * 二叉排序树 特点：
 * 1。左子结点的值小于当前结点
 * 2。右子结点的值大于当前结点
 * 3。如果和当前结点的值相等，那么插入到左子和右子都可以
 * <p>
 * 增 删 查
 */
public class BinarySortTree {
    private Node root;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public BinarySortTree(Node root) {
        this.root = root;
    }

    public BinarySortTree() {
    }

    /**
     * 将元素添加到树中
     */
    public void add(Node node) {
        if (root == null) {
            root = node;
        } else {
            root.addNode(node);
        }


    }

    /**
     * 中序遍历
     */
    public void middleSort() {
        if (this.root == null) {
            System.out.println("根结点为空 不能进行遍历");
            return;
        }
        this.root.middleSort();
    }


}
