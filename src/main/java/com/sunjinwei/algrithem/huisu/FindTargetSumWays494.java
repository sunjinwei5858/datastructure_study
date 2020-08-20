package com.sunjinwei.algrithem.huisu;

/**
 * 力扣449：目标和 回溯算法和动态规划 都可以解答
 * 给定一个数组，数组里面的数可进行加减，得到target值的方式有几种。
 * <p>
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
public class FindTargetSumWays494 {

    int result = 0;

    private int findTargetSumWays(int[] arr, int target) {
        if (arr.length == 0) {
            return 0;
        }

        //backTrack(arr, 0, target); // 第一种方式
        backTrack02(arr, 0, target, 0); // 第二种方式
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
    private void backTrack01(int[] nums, int i, int rest) {
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
        backTrack01(nums, i + 1, rest);
        // 撤销选择
        rest = rest - nums[i];

        // 给 nums[i] 选择 + 号
        rest = rest - nums[i];
        // 穷举 nums[i + 1]
        backTrack01(nums, i + 1, rest);
        // 撤销选择
        rest = rest + nums[i];
    }

    public static void main(String[] args) {
        FindTargetSumWays494 findTargetSumWays = new FindTargetSumWays494();
        int sumWays = findTargetSumWays.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3);
        System.out.println(sumWays);

    }

    /**
     * 使用第二种思考方式 如果需要将sum凑到target, 需要多传入一个参数
     *
     * @param nums   数组
     * @param i
     * @param target
     * @param sum
     */
    private void backTrack02(int[] nums, int i, int target, int sum) {
        // base case
        if (i == nums.length) {
            if (target == sum) {
                // 说明恰好凑出 target
                result++;
            }
            return;
        }
        // 给 nums[i] 选择 - 号
        sum = sum + nums[i];
        // 穷举 nums[i + 1]
        backTrack02(nums, i + 1, target, sum);
        // 撤销选择
        sum = sum - nums[i];

        // 给 nums[i] 选择 + 号
        sum = sum - nums[i];
        // 穷举 nums[i + 1]
        backTrack02(nums, i + 1, target, sum);
        // 撤销选择
        sum = sum + nums[i];
    }


}
