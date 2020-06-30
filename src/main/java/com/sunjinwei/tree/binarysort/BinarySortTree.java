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
     * 根据value值删除元素,删除节点其实分三种情况
     * 1。删除叶子节点
     * 2。删除非叶子节点，删除只有一颗子树的节点
     * 3。删除非叶子节点，删除有两颗子树的节点
     */
    public void deleteNode(int value) {

        // 根据value值找到节点
        Node targetNode = search(value);
        // 找到父节点
        Node parentNode = searchParent(value);

        /**
         * 1。删除叶子节点，根据目标值找到目标节点，然后找到父节点，判断目标节点是左还是右，然后置为null
         */
        if (targetNode.getLeft() == null && targetNode.getRight() == null) {
            // 判断是左子节点 还是右子节点
            if (parentNode.getLeft() != null && parentNode.getLeft().getValue() == value) {
                parentNode.setLeft(null);
            } else if (parentNode.getRight() != null && parentNode.getRight().getValue() == value) {
                parentNode.setRight(null);
            }
        }
        /**
         * 3.删除非叶子节点 删除有两颗子树的节点 这里面有两个子树的节点比较好判断 左右都不为null.
         * 思路：如果有两颗子树，要么找到左子树中最大的来代替，要么找到右子树中最小的来替代，是为了保证排序 从小到大
         * 就是将值set进去即可。
         * 如果不用为了排序 那么直接根据普通的左子树接上或者右子树接上即可。
         */
        else if (targetNode.getLeft() != null && targetNode.getRight() != null) {
            int nodeMin = delRightNodeMin(targetNode.getRight());
            targetNode.setValue(nodeMin);
        }
        /**
         * 2.删除非叶子节点 删除只有一颗子树的节点.
         *思路：
         * 1。判断target的子树是左子还是右子
         * 2。如果是左子，那么parent的left指向该左子；如果是右子 那么parent的right指向该右子
         * 注意：如果此时只有两个节点：一个根节点+一个左子节点
         * 此时 删除根节点 根节点是没有parent的 所以这里需要分情况
         * 如果是删除根节点 那么删除根节点之后, 就只剩下一个节点，此时root节点应该指向左子节点
         * 如果不是删除根节点 那么目标节点的左子节点
         */
        else {
            // 如果target的左子节点不为空
            if (targetNode.getLeft() != null) {
                if (parentNode != null) {
                    if (parentNode.getLeft().getValue() == value) {
                        parentNode.setLeft(targetNode.getLeft());
                    } else {
                        parentNode.setRight(targetNode.getLeft());
                    }
                } else {
                    root = targetNode.getLeft();
                }
            } else { // 如果target的左子节点不为空
                if (parentNode != null) {
                    if (parentNode.getLeft().getValue() == value) {
                        parentNode.setLeft(targetNode.getLeft());
                    } else {
                        parentNode.setRight(targetNode.getRight());
                    }

                } else {
                    root = targetNode.getRight();
                }
            }
        }
    }

    /**
     * 删除以node为根节点的左子树中的最大节点的值
     */
    public int delLeftNodeMax(Node node) {
        Node temp = node;
        while (temp.getRight() != null) {
            temp = temp.getRight();
        }
        deleteNode(temp.getValue());
        return temp.getValue();
    }

    /**
     * 删除以node为根节点的右子树中的最小节点的值
     */
    public int delRightNodeMin(Node node) {
        Node temp = node;
        while (temp.getLeft() != null) {
            temp = temp.getLeft();
        }
        deleteNode(temp.getValue());
        return temp.getValue();
    }


    /**
     * 查找节点
     */
    public Node search(int value) {
        if (root == null) {
            return null;
        } else {
            return root.searchNode(value);
        }
    }

    /**
     * 查找父节点
     */
    public Node searchParent(Integer value) {
        if (root == null) {
            return null;
        } else {
            return root.searchParent(value);
        }
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
