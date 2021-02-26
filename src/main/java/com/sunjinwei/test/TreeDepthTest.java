package com.sunjinwei.test;

import com.sunjinwei.tree.binarysort06.Node;

public class TreeDepthTest {

    public static int getTreeDepth(Node node) {
        if (node == null) {
            return 0;
        }
        int left = getTreeDepth(node.getLeft());
        int right = getTreeDepth(node.getRight());
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        Node left1 = new Node(2);
        Node right1 = new Node(10);
        root.setLeft(left1);
        root.setRight(right1);
        Node left2 = new Node(1);
        Node right2 = new Node(3);
        left1.setLeft(left2);
        left1.setRight(right2);



        int treeDepth = getTreeDepth(root);

        System.out.println(treeDepth);


    }

}
