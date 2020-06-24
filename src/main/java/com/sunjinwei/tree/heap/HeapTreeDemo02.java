package com.sunjinwei.tree.heap;

import java.util.Arrays;

/**
 * 第二种写法-----
 * 堆排序: 是完全二叉树
 * 堆特点：
 * 大顶堆满足条件 arr(i)>arr(2*i+1) && arr(i)>arr(2*i+2)
 * 小顶堆满足条件 arr(i)<arr(2*i+1) && arr(i)<arr(2*i+2)
 * 堆排序基本思想：
 * 1.首先将待排序的数组构造成一个大根堆，此时，整个数组的最大值就是堆结构的顶端
 * 2.将顶端的数与末尾的数交换，此时，末尾的数为最大值，剩余待排序数组个数为n-1
 * 3.将剩余的n-1个数再构造成大根堆，再将顶端数与n-1位置的数交换，如此反复执行，便能得到有序数组
 * 将无序数组构造成一个大根堆（升序用大根堆，降序就用小根堆）
 */
public class HeapTreeDemo02 {

    public static void main(String[] args) {

        int arr[] = {4, 6, 8, 5, 9};

        System.out.println("排序前：" + Arrays.toString(arr));

        for (int i = 0; i < arr.length; i++) {
            maxHeap(arr, arr.length - i);
            swap(arr, 0, arr.length - 1 - i);
        }

        System.out.println("排序后：" + Arrays.toString(arr));

    }

    /**
     * 交换元素方法 将index01的值换给index02
     *
     * @param arr
     * @param index01
     * @param index02
     */
    public static void swap(int[] arr, int index01, int index02) {
        int temp = arr[index01];
        arr[index01] = arr[index02];
        arr[index02] = temp;

    }

    /**
     * 建堆
     *
     * @param arr              完全二叉树的数组
     * @param currentNodeIndex 非叶子结点的索引
     * @param length           数组的长度
     */
    public static void adjustHeap(int[] arr, int currentNodeIndex, int length) {

        if (currentNodeIndex < length) {
            // 左结点的索引
            int leftNodeIndex = 2 * currentNodeIndex + 1;
            // 右结点的索引
            int rightNodeIndex = 2 * currentNodeIndex + 2;
            // 假设最大值的索引就是当前结点的索引 把当前父节点位置看成是最大的
            int maxNodeIndex = currentNodeIndex;

            // 1进行比较
            // 如果最大结点小于左结点
            if (leftNodeIndex < length) {
                // 比较左结点和当前结点的值
                if (arr[maxNodeIndex] < arr[leftNodeIndex]) {
                    maxNodeIndex = leftNodeIndex;
                }
            }
            // 如果最大结点小于右结点
            if (rightNodeIndex < length) {
                if (arr[maxNodeIndex] < arr[rightNodeIndex]) {
                    maxNodeIndex = rightNodeIndex;
                }
            }

            // 2如果最大的不是根元素位置，那么就交换 交换当前结点和最大值的值
            if (maxNodeIndex != currentNodeIndex) {
                // 使用临时变量存储最大值
                int temp = arr[maxNodeIndex];
                // 将当前结点的值赋给最大值索引的值
                arr[maxNodeIndex] = arr[currentNodeIndex];
                // 将最大值赋值给当前父结点
                arr[currentNodeIndex] = temp;
                // 继续比较 构造堆
                adjustHeap(arr, maxNodeIndex, length);
            }
        }
    }

    /**
     * 完成一次建堆，最大值在堆的顶部(根节点)
     */
    public static void maxHeap(int[] arr, int length) {
        // 从数组的尾部开始，直到第一个元素(角标为0)
        for (int i = length - 1; i >= 0; i--) {
            adjustHeap(arr, i, length);
        }


    }

}
