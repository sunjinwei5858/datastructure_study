package com.sunjinwei.tree.binarysort;

public class BinarySortTreeDemo {
    public static void main(String[] args) {
        int[] arr = {7, 3};
        BinarySortTree binarySortTree = new BinarySortTree();
        for (int i : arr) {
            binarySortTree.add(new Node(i));
        }
        // 测试一把 中序遍历
        binarySortTree.middleSort(); // 1 2 3 5 7 9 10 12
        System.out.println("删除节点后=======");
        // 删除节点
        binarySortTree.deleteNode(3);

        binarySortTree.middleSort(); // 3 5 7 9 10 12


    }
}
