package com.sunjinwei.tree.arrbinary01;

/**
 * 数组二叉树对象
 * <p>
 * 顺序存储二叉树的特点:
 * <p>
 * 1. 顺序二叉树通常只考虑完全二叉树；
 * 2. 第n个元素的左子结点为2n+1;
 * 3. 第n个元素的右子结点为2n+2;
 * 4. 第n个元素的父结点为(n-1)/2；
 * 5. n：表示二叉树中的第几个元素 按0开始编号
 */
public class ArrayBinaryTree {

    private int[] arrs;

    public ArrayBinaryTree(int[] arrs) {
        this.arrs = arrs;
    }

    public int[] getArrs() {
        return arrs;
    }

    public void setArrs(int[] arrs) {
        this.arrs = arrs;
    }

    /**
     * 编写一个前序遍历方法 需要结合顺序存储二叉树的特点来分析
     * index: 为数组的索引
     */
    public void preOrder(int index) {
        // 如果数组为空 直接返回
        if (arrs == null && arrs.length == 0) {
            System.out.println("数组为空 ");
            return;
        }
        /**
         * 前序遍历 首先输出root结点
         */
        System.out.println(arrs[index]);

        /**
         * 需要加上判断 如果子结点的索引小于数组的长度 那么才可以进行递归
         */
        if ((index * 2 + 1) < arrs.length) {
            preOrder((index * 2 + 1));
        }

        /**
         * 需要加上判断 如果右子结点的索引小于数组的长度 那么才可以进行递归
         */
        if ((index * 2 + 2) < arrs.length) {
            preOrder((index * 2 + 2));
        }
    }

    /**
     * 改进： 为了代码更加简洁 使用重载
     */
    public void preOrder() {
        this.preOrder(0);
    }


}
