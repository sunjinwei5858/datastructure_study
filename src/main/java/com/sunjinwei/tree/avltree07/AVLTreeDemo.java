package com.sunjinwei.tree.avltree07;

public class AVLTreeDemo {
    public static void main(String[] args) {

        //int[] arr = {4, 3, 6, 5, 7, 8}; // 只需要一次左旋的数组

        int[] arr = {10, 12, 8, 9, 7, 6}; // 只需要一次右旋的数组

        AVLTree binarySortTree = new AVLTree();
        for (int value : arr) {
            binarySortTree.add(new Node(value));
        }
        // 测试一把 中序遍历
        binarySortTree.middleSort();
        // 获取根节点的高度
        System.out.println("根节点的高度为：" + binarySortTree.getRoot().height());
        System.out.println("根节点的左子节点的高度：" + binarySortTree.getRoot().leftHeight());
        System.out.println("根节点的右子节点的高度：" + binarySortTree.getRoot().rightHeight());

        System.out.println("根结点的value为：" + binarySortTree.getRoot());
        System.out.println("根结点的左结点的value为：" + binarySortTree.getRoot().getLeft());
        System.out.println("根结点的右结点的value为：" + binarySortTree.getRoot().getRight());


    }
}
