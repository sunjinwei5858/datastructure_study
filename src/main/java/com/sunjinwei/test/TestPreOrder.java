package com.sunjinwei.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * N 叉树的前序遍历
 */
public class TestPreOrder {

    List<Integer> result = Collections.EMPTY_LIST;

    public List<Integer> preOrder(Node root) {
        if (root == null) {
            return Collections.emptyList();
        }

        result.add(root.val);

        if (root.children != null) {
            for (Node child : root.children) {
                preOrder(child);
            }
        }
        return result;
    }


    public static void main(String[] args) {
        Node root = new Node(5);
        Node left1 = new Node(2);
        Node left2 = new Node(1);
        Node right1 = new Node(3);
        Node right2 = new Node(10);

        ArrayList<Node> nodes = new ArrayList<>();


    }
}
