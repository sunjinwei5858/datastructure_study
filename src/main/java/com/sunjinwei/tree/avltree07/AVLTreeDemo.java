package com.sunjinwei.tree.avltree07;

public class AVLTreeDemo {
    public static void main(String[] args) {
        //int[] arr = {10, 11, 7, 6, 8, 9};

        int[] arr = {4, 3, 6, 5, 7, 8}; // 需要左旋数组

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

    }
}
