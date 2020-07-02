package com.sunjinwei.tree.avltree07;

/**
 * 平衡二叉树：
 * 1。获取节点的高度
 * 2。添加完元素后进行判断高度 进行左旋和右旋 -->单旋转
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
     * 左旋方法：
     * 1。创建一个新结点，value为当前结点的value。
     * 2。新结点的左子树设置为当前结点的左子树
     * 3.新结点的右子树设置为当前结点右子树的左子树
     * 4.当前结点的值换为它右子结点的值
     * 5.当前结点的右子树换为它右子树的右子树
     * 6.当前结点的左子树换为新结点
     */
    public void leftRotate() {
        Node newNode = new Node(value);
        newNode.left = left;
        newNode.right = right.left;
        value = right.value;
        right = right.right;
        left = newNode;
    }

    /**
     * 右旋方法：
     * 1.创建一个新的结点，value为当前结点的value
     * 2。新结点的左子树->当前结点的左子树的右子树
     * 3。新结点的右子树->当前结点的右子树
     * 4。当前结点的value->当前结点左子树的value
     * 5。当前结点的右子树->新结点
     * 6.当前结点的左子树->当前结点左子树的左子树
     */
    public void rightRotate() {
        Node newNode = new Node(value);
        newNode.left = left.right;
        newNode.right = right;
        value = left.value;
        left = left.left;
        right = newNode;
    }

    /**
     * 获取左子节点的高度
     */
    public int leftHeight() {
        if (left == null) {
            return 0;
        }
        return left.height();
    }

    /**
     * 获取右子节点的高度
     */
    public int rightHeight() {
        if (right == null) {
            return 0;
        }
        return right.height();
    }

    /**
     * 获取节点的高度
     */
    public int height() {
        return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
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
     * 添加元素+判断高度左旋/右旋+
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
        // 判断左子树和右子树的高度
        // 如果右边更高 那么进行左旋
        if (rightHeight() - leftHeight() > 1) {
            leftRotate();
            return; // !!!
        }
        // 如果左边更高 那么进行右旋
        if (leftHeight() - rightHeight() > 1) {
            rightRotate();
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
