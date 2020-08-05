package com.sunjinwei.algrithem.coinchange322;

import java.util.Arrays;

/**
 * 力扣：零钱兑换 322
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * <p>
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * <p>
 * 实现：
 * 方法1：使用动态规划 将大问题进行拆解成一个小问题
 * <p>
 * 来源：力扣（LeetCode）
 */
public class CoinChangeDemo01 {
    /**
     * 使用动态规划进行实现,暴力递归
     * 比如 {1,2,5} 金额为11 求硬币个数
     * 大问题： f(11)->
     * 1. f(11-1)+1=f(10)+1=11---> f(10)+面值为1的这一枚 即f(10)+1
     * 2. f(11-2)+2=f(9)+2=11--->  f(9)+面值为2的这一枚 即f(9)+1
     * 3. f(11-5)+5=f(6)+5=11--->  f(6)+面值为5的这一枚 即f(6)+1
     * ===》dp(11)-> min{f(10)+1, f(9)+1, f(6)+1} 里面这三次比较其实就是遍历 找最小
     *
     * @param coins
     * @param amount
     * @return
     */
    public  int coinChange(int[] coins, int amount) {
        // 备忘录数组 记录
        int[] arr = new int[amount + 1];
        // 注意：因为要比较的是最小值，这个不可能的值就得赋值成为一个最大值
        Arrays.fill(arr, amount + 1);
        arr[0] = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int coin : coins) {
                // !!! 当前的面值肯定要大于
                if (i - coin >= 0) {
                    // ！！！ 新状态的值要参考的值以前计算出来的「有效」状态值
                    // 这种当前状态的问题可以转化成之前状态问题的，一般就是动态规划的套路
                    // 求 dp[11] 需要参考 dp[10] ，如果不能凑出来的话，dp[10] 应该等于一个不可能的值，可以设计为 11 + 1，也可以设计为 -1
                    arr[i] = Math.min(arr[i - coin] + 1, arr[i]);
                }
            }
        }
        // 只要有解，最小硬币数必然小于amount+1
        if (arr[amount] == amount + 1) {
            return -1;
        } else {
            return arr[amount];
        }
    }

    public static void main(String[] args) {
        CoinChangeDemo01 coinChangeDemo01 = new CoinChangeDemo01();
        int[] coins = {1, 2, 5};
        int amount = 11;
        int coinChange = coinChangeDemo01.coinChange(coins, amount);
        System.out.println(coinChange);
    }


}
