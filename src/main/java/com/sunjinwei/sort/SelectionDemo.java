package com.sunjinwei.sort;

import com.sunjinwei.utils.SortUtils;

import java.util.Arrays;

/**
 * 选择排序：
 * 遍历元素找到一个最小（或最大）的元素，把它放在第一个位置；
 * 以此类推，找到最小的，放在第二个位置。
 * <p>
 * 依次类推，直到第N-1个元素与第N个元素交换位置，选择排序结束。
 */
public class SelectionDemo {
    public static void main(String[] args) {

        Integer[] arr = {3, 1, 10, 7, 2};

        SelectionDemo.sort(arr);

        System.out.println(Arrays.toString(arr));

    }

    /**
     * 选择排序思想：
     * 外循环:索引为i处的值与其余的进行比较
     * 内循环:从索引为i+1处的值进行比较
     * <p>
     * 第一轮循环：第一个数分别与第二个 第三个 第四个..比较
     * 第二轮循环：第二个数分别与第三个 第四个 ..比较
     *
     * @param arr
     */
    public static void sort(Integer[] arr) {
        // 只需要比较length-1次
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            // 找出最小值
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            SortUtils.exchangeIndex(arr, minIndex, i);
        }
    }
}
