package com.sunjinwei.algrithem.minidepth111;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 力扣111，判断一棵二叉树的最小高度---bfs解法 广度优先遍历
 */
public class TreeMiniDepth {
    public int miniDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 声明一个队列
        Queue<TreeNode> queue = new LinkedList<>();
        int minDepth = 0;
        queue.offer(root);
        while (!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                TreeNode current = queue.poll();
                if (current.getLeft() == null && current.getRight() == null) {
                    return minDepth;
                }
                if ((current.getLeft() != null)) {
                    queue.offer(current.getLeft());
                }
                if (current.getRight() != null) {
                    queue.offer(current.getRight());
                }
            }
            minDepth++;
        }
        return minDepth;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode left1 = new TreeNode(2);
        root.setLeft(left1);
        TreeNode right1 = new TreeNode(8);
        root.setRight(right1);

        TreeNode left2 = new TreeNode(7);
        right1.setLeft(left2);
        TreeNode right2 = new TreeNode(10);
        right1.setRight(right2);

        TreeNode right3 = new TreeNode(12);
        right2.setRight(right3);

        TreeMiniDepth treeMiniDepth = new TreeMiniDepth();
        int miniDepth = treeMiniDepth.miniDepth(root);
        System.out.println(miniDepth);
    }
}



class TreeNode {
    private TreeNode left;
    private TreeNode right;
    private int value;

    public TreeNode(int value) {
        this.value = value;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
