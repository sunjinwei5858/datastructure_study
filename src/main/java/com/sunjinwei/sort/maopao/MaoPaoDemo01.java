package com.sunjinwei.sort.maopao;

import com.sunjinwei.utils.SortUtils;

import java.util.Arrays;

/**
 * 冒泡排序基本思想：交换排序，俩俩比较相邻记录的关键字，如果反序则交换；直到没有反序的记录为止。
 * 冒泡排序的初级写法--比较容易理解的一种
 */
public class MaoPaoDemo01 {
    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 3, 8, 4, 2};
        mapPaoFirstSort(arr);

        System.out.println(Arrays.toString(arr));

    }

    private static void mapPaoFirstSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    SortUtils.exchangeIndex(arr, i, j);
                }
            }
        }
    }


}
