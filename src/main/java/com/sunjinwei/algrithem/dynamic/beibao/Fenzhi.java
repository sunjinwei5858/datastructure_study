package com.sunjinwei.algrithem.dynamic.beibao;

/**
 * 0/1背包问题：分治法实现
 * 案例：
 * 4个商品，价值分别是 2 4 3 7
 *        重量分别是 2 3 5 5
 * 包的最大容量为10，得出包能拥有的最大价值。
 * 分治法： 原问题是，将n件物品放入容量为c的背包，子问题则是，将前i件物品放入容量为j的背包，所得到的最优价值为KS(i,j)
 *  如果只考虑第i件物品放还是不放，那么就可以转化为一个只涉及到前i-1个物品的问题。
 *  如果不放第i个物品，那么问题就转化为“前i-1件物品放入容量为j的背包中的最优价值组合”，对应的值为KS(i-1,j)。
 *  如果放第i个物品，那么问题就转化成了“前i-1件物品放入容量为j-wi的背包中的最优价值组合”，此时对应的值为KS(i-1,j-wi)+vi。
 */
public class Fenzhi {
    public static void main(String[] args) {
        // 这里为了方便处理，将数组ws和vs都增加了一个补位数0，防止数组越界
        int[] valueArr = {0, 2, 4, 3, 7};
        int[] weightValue = {0, 2, 3, 5, 5};
        int result = ks(4, 10, valueArr, weightValue);
        System.out.println(result);
    }

    /**
     * @param n        4个物品
     * @param capacity 包能装下的容量
     * @return
     */
    private static int ks(int n, int capacity, int[] vs, int[] ws) {
        int result = 0;
        if (n == 0 || capacity == 0) {
            result = 0;
        } else if (ws[n] > capacity) {
            // 装不下该珠宝
            result = ks(n - 1, capacity, vs, ws);
        } else {
            // 可以装下
            int temp01 = ks(n - 1, capacity, vs, ws);
            int temp02 = ks(n - 1, capacity - ws[n], vs, ws) + vs[n];
            result = Math.max(temp01, temp02);
        }
        return result;
    }
}
