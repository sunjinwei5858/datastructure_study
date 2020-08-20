package com.sunjinwei.algrithem.dynamic.feibo509;

/**
 * 斐波那契数列--最优的实现
 * 不需要使用递归，并且空间复杂为1
 * 时间复杂度O(N)
 * 空间复杂度O(1)
 */
public class FeiBoDemo004 {
    public static void main(String[] args) {
        int fib = fib(0);
        System.out.println(fib);

    }

    /**
     * 情况 n >= 0
     *
     * @param n
     * @return
     */
    public static int fib(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1 || n == 2) {
            return 1;
        }
        // 前一个值
        int prev = 1;
        // 当前值
        int curr = 1;
        for (int i = 3; i <= n; i++) {
            int sum = prev + curr;
            prev = curr;
            curr = sum;
        }
        return curr;
    }
}
