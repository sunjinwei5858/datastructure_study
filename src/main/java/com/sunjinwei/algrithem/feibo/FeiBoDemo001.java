package com.sunjinwei.algrithem.feibo;

/**
 * 使用递归实现
 */
public class FeiBoDemo001 {
    public static void main(String[] args) {
        int fib = fib(3);
        System.out.println(fib);

    }

    public static int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

}
