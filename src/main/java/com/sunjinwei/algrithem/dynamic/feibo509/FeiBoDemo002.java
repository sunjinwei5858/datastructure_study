package com.sunjinwei.algrithem.dynamic.feibo509;

/**
 * 斐波那契额数列-使用备忘录实现,即使用数组进行存储n-f(n)
 * 一般使用一个数组充当这个「备忘录」，当然你也可以使用哈希表（字典），思想都是一样的。
 * 时间复杂度O(N) 空间复杂度O(N)
 */
public class FeiBoDemo002 {

    public static void main(String[] args) {
        int fib = fib(5);
        System.out.println(fib);

    }

    public static int fib(int n) {
        if (n == 0) {
            return 0;
        }
        // 创建备忘录
        int[] arr = new int[n + 1];
        return helper(n, arr);
    }

    /**
     * 带备忘录的递归
     *
     * @param n
     * @param arr
     * @return
     */
    private static int helper(int n, int[] arr) {
        if (n == 1 || n == 2) {
            return 1;
        }
        if (arr[n] != 0) {
            return arr[n];
        }
        arr[n] = helper(n - 1, arr) + helper(n - 2, arr);
        return arr[n];
    }

}
