package com.sunjinwei.tree.binarysort;

/**
 * 二叉排序树的结点
 */
public class Node {

    // 值
    private int value;

    // 左子结点
    private Node left;

    // 右子结点
    private Node right;

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    /**
     * 添加元素
     */
    public void addNode(Node node) {
        int currentValue = this.getValue();
        if (currentValue > node.getValue()) {
            // 添加到左子结点 如果左子结点是null 那么直接进行赋值
            if (this.left == null) {
                this.left = node;
            } else {
                // 如果左子结点不为空 那么继续调用
                this.left.addNode(node);
            }
        } else {
            // 添加到右子结点 如果右子结点是null 那么直接进行赋值
            if (this.right == null) {
                this.right = node;
            } else {
                // 如果右子结点不为空 那么继续调用
                this.right.addNode(node);
            }
        }

    }

    /**
     * 中序遍历
     *
     * @return
     */
    public void middleSort() {
        if (this.left != null) {
            this.left.middleSort();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.middleSort();
        }
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }


}
