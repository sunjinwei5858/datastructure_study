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
        Integer[] arr01 = {3, 1, 10, 7, 4, 3, 9, 2};

        System.out.println("数组长度为：" + arr01.length);

        sort01(arr01);

        System.out.println("双重for循环冒泡排序后的数组为：" + Arrays.toString(arr01));

        System.out.println("======================");

        Integer[] arr02 = {3, 1, 10, 7, 4, 3, 9, 2};

        System.out.println("数组长度为：" + arr02.length);

        sort02(arr02);

        System.out.println("while循环冒泡排序后的数组为：" + Arrays.toString(arr02));

    }

    /**
     * 方法一：
     * 进行冒泡排序
     *
     * @param arr
     */
    public static void sort01(Integer[] arr) {
        // 外层循环 控制趟数 length-1次
        for (int i = 0; i < arr.length - 1; i++) {
            // 内层循环 因为每次都会将最大的数排在最右边 所以第二趟都会比第一趟少一次 第三趟会比第二趟少一次
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (handlerMinAndMax(arr[j], arr[j + 1])) {
                    exchangeIndex(arr, j, j + 1);
                }
            }
        }
    }

    /**
     * 方法二：使用while循环代替外层循环 更好理解
     *
     * @param arr
     */
    public static void sort02(Integer[] arr) {
        // 最后一个无需进行比较 所以while循环 如果只剩下最后一个元素 那么无需进行比较 跳出循环
        int length = arr.length;
        while (length > 1) {
            for (int i = 0; i < arr.length - 1; i++) {
                if (handlerMinAndMax(arr[i], arr[i + 1])) {
                    exchangeIndex(arr, i, i + 1);
                }
            }
            length--;
        }
    }


    /**
     * 进行比较两个数大小
     * 如果a>b 为true；如果a<b 为false
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
