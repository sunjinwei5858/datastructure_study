package com.sunjinwei.tree.binarysort06;

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
     * 根据value值查找节点, 通过二分查找的方式 不需要和原来的前序查找 中序查找 后序查找的方式那样查找了
     */
    public Node searchNode(int value) {
        // 如果值等于当前节点
        if (value == this.value) {
            return this;
        }
        // 如果值小于当前节点的值 那么向左进行查找
        else if (value < this.value) {
            // 需要判断左子树不能为空情况
            if (this.left != null) {
                return this.left.searchNode(value);
            } else {
                return null;
            }
        }
        // 如果值大于当前节点的值 那么向右进行查找
        else if (value > this.value) {
            if (this.right != null) {
                return this.right.searchNode(value);
            } else {
                return null;
            }
        } else {
            return null;
        }

    }

    /**
     * 根据节点查找当前节点的父节点
     */
    public Node searchParent(int value) {
        // 如果当前节点的左子节点的值等于value或者右子节点的值等于value
        if ((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)) {
            return this;
        } else {
            // 如果value小于当前节点的value 并且左子树不为空 那么进行递归查找
            if (this.value > value && this.left != null) {
                return this.left.searchParent(value);
            }
            // 如果value小于当前节点的value 并且左子树不为空 那么进行递归查找
            else if (this.value < value && this.right != null) {
                return this.right.searchParent(value);
            } else {
                // 最后一种情况 没有父节点
                return null;
            }
        }
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
