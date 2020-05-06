package com.sunjinwei.sort;

import java.util.Arrays;

/**
 * 冒泡排序： 画图
 * 1。外层循环
 * 先拿第一个数依次跟别的数进行比较
 * 2。内层循环
 * 进行内循环比较相邻两数的大小 并且进行交换
 */
public class MaoPaoDemo {

    public static void main(String[] args) {
        // 长度为5的数组 因为数组索引是从0开始 那么只需要n-1次外循环 内循环就是n-1-1次
        Integer[] arr = {3, 1, 10, 7, 4};

        System.out.println(arr.length);

        MaoPaoDemo.sort(arr);
        System.out.println(Arrays.toString(arr));

    }

    /**
     * 进行冒泡排序
     *
     * @param arr
     */
    public static void sort(Integer[] arr) {
        // 外层循环 控制趟数 length-1次
        for (int i = 0; i < arr.length - 1; i++) {
            // 内层循环 还需要将-i次即可
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (handlerMinAndMax(arr[j], arr[j + 1])) {
                    exchangeIndex(arr, j, j + 1);
                }
            }
        }
    }


    /**
     * 进行比较两个数大小
     *
     * @param a
     * @param b
     * @return 大于0 说明a>b
     */
    public static Boolean handlerMinAndMax(Integer a, Integer b) {
        return a.compareTo(b) > 0;
    }

    /**
     * 进行替换
     *
     * @param arr
     * @param minIndex
     * @param maxIndex
     */
    public static void exchangeIndex(Integer[] arr, Integer minIndex, Integer maxIndex) {
        Integer temp;
        temp = arr[minIndex];
        Integer min = arr[maxIndex];
        arr[minIndex] = min;
        arr[maxIndex] = temp;
    }

}
