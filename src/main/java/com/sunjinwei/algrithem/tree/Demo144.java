package com.sunjinwei.algrithem.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的前序遍历: 根 左子树 右子树
 */
public class Demo144 {

    private List<Integer> integers = new ArrayList<>();

    /**
     * 使用递归法
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return integers;
        }
        integers.add(root.val);
        if (root.left != null) {
            preorderTraversal(root.left);
        }

        if (root.right != null) {
            preorderTraversal(root.right);
        }
        return integers;
    }

    /**
     * 使用栈的先进后出特点：
     * 先将
     */


}
