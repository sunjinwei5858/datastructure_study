package com.sunjinwei.hash;

/**
 * 给你n个自然数(1<n<10)，每个数的范围是(1-10000)，现在让你以最快的速度判断某个数在这N个范围内，不准使用HashMap，该如何实现？
 * 比如n：5 ，5个数：10 50 60 1 5
 * 判断7在不在
 * 如何实现？
 */
public class HashTest {
    public static void main(String[] args) {
        // 50 40 12 11 2 判断7存不存
        // 定义一个数组 长度为最大范围那个数
        // 将这五个数作为下标 设置到该数组中 对应的value为1
        int[] arr = new int[10000];
        arr[50] = 1;
        arr[40] = 1;
        arr[12] = 1;
        arr[11] = 1;
        arr[2] = 1;

        int value = arr[7];
        System.out.println(value);

    }
}
