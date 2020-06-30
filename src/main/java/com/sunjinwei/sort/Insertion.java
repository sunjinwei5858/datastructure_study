package com.sunjinwei.sort;

import com.sunjinwei.utils.SortUtils;

import java.util.Arrays;

/**
 * 插入排序
 * 思想：1假设第一个元素是有序的 2然后将第二个元素与第一个元素进行比较 如果第一个元素大于第二个元素 那么进行交换
 */
public class Insertion {

    public static void main(String[] args) {
        Integer[] arr = {3, 1, 10, 7, 4};
        Insertion.sort(arr);

        System.out.println(Arrays.toString(arr));


    }


    public static void sort(Integer[] arr) {
        // 外循环 假设第一个索引处的是排序好的
        // 索引从1开始 倒叙遍历
        // 第一次插入 将索引1和索引0处的进行比较 如果大于的话 那么进行交换 ；如果小于 那么不需要进行交换 索引1的比较交换结束
        // 第二次插入 将索引2和索引1处的进行比较 如果大于的话 那么进行交换 然后索引1和索引0进行比较 如果大于 进行交换；如果小于0 那么break
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (SortUtils.handlerMinAndMax(arr[j - 1], arr[j])) {
                    SortUtils.exchangeIndex(arr, j - 1, j);
                } else {
                    break;
                }
            }
        }

    }

}
