package com.sunjinwei.algrithem.feibo509;

/**
 * 斐波那契额数列 使用数组实现
 */
public class FeiBoDemo003 {
    public static void main(String[] args) {
        int fib = fib(5);
        System.out.println(fib);
    }

    public static int fib(int n) {
        if (n == 0) {
            return 0;
        }
        int[] arr = new int[n + 1];
        arr[1] = 1;

        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }

}
