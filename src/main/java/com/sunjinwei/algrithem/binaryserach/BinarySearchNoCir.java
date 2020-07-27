package com.sunjinwei.algrithem.binaryserach;

/**
 * 非递归实现二分查找，这里需要注意二叉树必须有有序 如升序
 */
public class BinarySearchNoCir {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 6, 9, 10};
        int index = binaryQuery(arr, 6);
        System.out.println(index);

    }

    /**
     * 二分查找
     *
     * @param arr
     * @param target
     * @return 返回目标元素的下标 如果不存在 那么返回-1
     */
    public static int binaryQuery(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (arr[middle] == target) {
                return middle;
            }
            if (target > arr[middle]) {
                // 向右查找
                left = middle + 1;
            } else {
                // 向左查找
                right = middle - 1;
            }
        }
        return -1;
    }


}
