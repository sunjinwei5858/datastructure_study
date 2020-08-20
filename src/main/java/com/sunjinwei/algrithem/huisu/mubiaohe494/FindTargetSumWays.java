package com.sunjinwei.algrithem.huisu.mubiaohe494;

/**
 * 力扣449：目标和
 * 给定一个数组，数组里面的数可进行加减，得到target值的方式有几种
 * 使用回溯算法：模板如下
 * def backtrack(路径, 选择列表):
 * if 满足结束条件:
 * result.add(路径)
 * return
 * for 选择 in 选择列表:
 * 做选择
 * backtrack(路径, 选择列表)
 * 撤销选择
 * ==========================================================
 */
public class FindTargetSumWays {
    int result = 0;

    public int findTargetSumWays(int[] arr, int target) {
        if (arr.length == 0) {
            return 0;
        }
        backTrack(arr, 0, target);
        return result;
    }

    /**
     * 「如何凑出 target」和「如何把 target 减到 0」其实是一样的。我们这里选择后者.
     * 因此，如果我们给 nums[i] 选择 + 号，就要让 rest - nums[i]
     *
     * @param nums
     * @param i
     * @param rest
     */
    private void backTrack(int[] nums, int i, int rest) {
        // base case
        if (i == nums.length) {
            if (rest == 0) {
                // 说明恰好凑出 target
                result++;
            }
            return;
        }
        // 给 nums[i] 选择 - 号
        rest = rest + nums[i];
        // 穷举 nums[i + 1]
        backTrack(nums, i + 1, rest);
        // 撤销选择
        rest = rest - nums[i];

        // 给 nums[i] 选择 + 号
        rest = rest - nums[i];
        // 穷举 nums[i + 1]
        backTrack(nums, i + 1, rest);
        // 撤销选择
        rest = rest + nums[i];
    }

    public static void main(String[] args) {
        FindTargetSumWays findTargetSumWays = new FindTargetSumWays();
        int sumWays = findTargetSumWays.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3);
        System.out.println(sumWays);

    }


}
