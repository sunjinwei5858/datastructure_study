package com.sunjinwei.tree.arrbinary;

import java.util.Arrays;

/**
 * 使用顺序存储二叉树 进行对数组{1,2,3,4,5,6,7} 使用二叉树前序遍历
 */
public class ArrayBinaryTreeDemo {
    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4,5,6,7};
        System.out.println(Arrays.toString(array));

        ArrayBinaryTree arrayBinaryTree = new ArrayBinaryTree(array);

        /**
         * 前序遍历 输出1，2，4，5，3，6，7
         */
        arrayBinaryTree.preOrder();

    }

}
