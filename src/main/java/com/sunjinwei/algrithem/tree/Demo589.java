package com.sunjinwei.algrithem.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * N叉树的前序遍历， 难度：简单
 */
public class Demo589 {

    private List<Integer> result = new ArrayList<>();

    /**
     * 方法一：暴力递归方式
     * 解决思路： 类似二叉树的暴力递归：根节点，然后递归遍历左子树，最后递归遍历右子树
     * 时间复杂度O(N),空间复杂度O(N)
     *
     * @param root
     * @return
     */
    public List<Integer> preorder(Node root) {
        if (root == null) {
            return result;
        }

        result.add(root.val);

        for (Node child : root.children) {
            preorder(child);
        }

        return result;
    }

    /**
     * 方法二：非递归法，
     * 解决思路：类似二叉树的非递归遍历，使用栈的方式，因为栈的弹栈顺序为：先进后出.
     * 注意：这里需要右子树先进栈，然后左子树
     */
    private List<Integer> preOrder2(Node root) {
        if (root == null) {
            return result;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        // 如果栈不为空
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            result.add(node.val);
            for (int i = node.children.size() - 1; i >= 0; i--) {
                stack.add(node.children.get(i));
            }
        }
        return result;
    }


}
