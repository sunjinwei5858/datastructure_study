package com.sunjinwei.tree.heap;

import java.util.Arrays;

/**
 * 手写堆排序
 */
public class MyHeapSortTest {
    public static void main(String[] args) {
        int arr[] = {9,6};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    /**
     * 堆排序 升序
     */
    public static void heapSort(int[] arr) {
        // 1 构造大顶堆
        heapInsert(arr);
        int length = arr.length;
        // 当数组不止一个时 进行比较和交换 然后将剩余的元素数组进行构造大顶堆
        while (length > 1) {
            // 2 将根结点的值与最大索引处的值进行交换
            swap(arr, 0, length - 1);
            // 3 将剩余元素构造大顶堆 然后排序
            length--; // 数组长度减减
            adjustHeap(arr, 0, length);
        }
    }


    /**
     * 剩余元素调整成大顶堆 自顶向下
     */
    public static void adjustHeap(int[] arr, int currentIndex, int length) {
        // 获取当前结点的左结点
        int leftIndex = (2 * currentIndex) + 1;
        int rightIndex = (2 * currentIndex) + 2;
        // 如果左结点索引小于数组的长度
        while (leftIndex < length) {
            // 接下来进行判断当前结点与两个子结点 这三个结点的值哪个值大 将最大值交换到父结点
            int largeIndex = leftIndex; // 默认为左结点大
            // 先比较两个左右结点 哪个大 如果右结点更大 那么赋值给右结点索引
            if (rightIndex < length && arr[leftIndex] < arr[rightIndex]) {
                largeIndex = rightIndex;
            }
            // 然后拿左右结点的最大值与当前结点比较 如果当前结点大 那么赋值给当前结点
            if (arr[largeIndex] < arr[currentIndex]) {
                largeIndex = currentIndex;
            }
            // 判断当前索引和最大索引是不是相等
            if (currentIndex == largeIndex) {
                break;
            }
            // 否则 进行比较和交换
            swap(arr, currentIndex, largeIndex);
            // 将当前索引指向最大值的索引
            currentIndex = largeIndex;
            leftIndex = (2 * currentIndex) + 1;
            rightIndex = (2 * currentIndex) + 2;
        }
    }

    /**
     * 构造大顶堆方法
     */
    public static void heapInsert(int[] arr) {
        // 将数组第一次构成大顶堆
        for (int i = 0; i < arr.length; i++) {
            // 当前结点索引
            int currentIndex = i;
            // 获取该结点的父结点索引
            int parentIndex = (currentIndex - 1) / 2;
            // 只要当前结点的值大于父结点的值 那么就需要进行交换位置
            while (arr[currentIndex] > arr[parentIndex]) {
                swap(arr, currentIndex, parentIndex);
                // 此时当前结点索引指向父结点索引
                currentIndex = parentIndex;
                parentIndex = (currentIndex - 1) / 2;
            }
        }
    }


    /**
     * 交换元素方法
     */
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
