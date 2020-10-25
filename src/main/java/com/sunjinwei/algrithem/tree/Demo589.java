package com.sunjinwei.algrithem.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * N叉树的前序遍历:
 * 参考二叉树的前序遍历：先根节点-->左子树-->右子树
 * 所以N叉树的前序遍历方式为：先根节点-->子树即可
 */
public class Demo589 {

    private List<Integer> result = new ArrayList<>();

    /**
     * 方法一：暴力递归方式 时间复杂度O(N),空间复杂度O(N)
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

}
