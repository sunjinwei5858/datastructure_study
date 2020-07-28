package com.sunjinwei.utils;

/**
 * 排序工具类
 */
public class SortUtils {

    /**
     * 交换元素位置
     *
     * @param arr
     * @param index01
     * @param index02
     */
    public static void exchangeIndex(int[] arr, int index01, int index02) {
        int temp = arr[index01];
        int min = arr[index02];
        arr[index01] = min;
        arr[index02] = temp;
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


}
