package com.sunjinwei.algrithem.dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 全排列--力扣46
 * 回溯算法框架 使用了深度优先遍历 dfs
 * 输入: [1,2,3]
 * 输出:
 * [1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]
 * 从 [1, 2, 3] 到 [1, 3, 2] ，深度优先遍历是这样做的，从 [1, 2, 3] 回到 [1, 2] 的时候，
 * 需要撤销刚刚已经选择的数 3，因为在这一层只有一个数 3 我们已经尝试过了，
 * 因此程序回到上一层，需要撤销对 2 的选择，好让后面的程序知道，选择 3 了以后还能够选择 2。
 * <p>
 * 这种在遍历的过程中，从深层结点回到浅层结点的过程中所做的操作就叫“回溯”。
 * <p>
 * 解决一个回溯问题，实际上就是一个决策树的遍历过程。
 * 你只需要思考 3 个问题：
 * 1、路径：也就是已经做出的选择。
 * 2、选择列表：也就是你当前可以做的选择
 * 3、结束条件：也就是到达决策树底层，无法再做选择的条件。
 */
public class QuanPaiLie46 {

    List<List<Integer>> results = new ArrayList<>();

    private List<List<Integer>> quanPaiLie(int[] nums) {
        LinkedList<Integer> integers = new LinkedList<>();
        backtrack(nums, integers);
        return results;
    }

    /**
     * 框架：
     * for 选择 in 选择列表:
     * # 做选择
     * 将该选择从选择列表移除
     * 路径.add(选择)
     * backtrack(路径, 选择列表)
     * # 撤销选择
     * 路径.remove(选择)
     * 将该选择再加入选择列表
     * <p>
     * 路径：记录在 track 中
     * 选择列表：nums 中不存在于 track 的那些元素
     * 结束条件：nums 中的元素全都在 track 中出现
     *
     * @param nums  选择列表
     * @param track 路径 记录在 track 中
     */
    private void backtrack(int[] nums, LinkedList<Integer> track) {
        for (int i = 0; i < nums.length; i++) {
            // 结束条件：也就是到达决策树底层，无法再做选择的条件。nums 中的元素全都在 track 中出现
            if (track.size() == nums.length) {
                /**
                 * integers 这个变量所指向的对象在递归的过程中只有一份，深度优先遍历完成以后，
                 * 因为回到了根结点（因为我们之前说了，从深层结点回到浅层结点的时候，需要撤销之前的选择），
                 * 因此 integers 这个变量回到根结点以后都为空。
                 * 在 Java 中，因为都是值传递，对象类型变量在传参的过程中，复制的都是变量的地址.
                 */
                // new LinkedList<>(integers) 其实就是addAll
                results.add(new ArrayList<>(track));
                return;
            }
            // 选择列表：nums 中不存在于 track 的那些元素
            if (track.contains(nums[i])) {
                continue;
            }
            // 进行选择
            track.add(nums[i]);
            // 进行递归
            backtrack(nums, track);
            // 进行回溯 撤销
            track.removeLast();
        }

    }

    public static void main(String[] args) {
        QuanPaiLie46 quanPaiLieDemo01 = new QuanPaiLie46();
        int[] arr = {1, 2, 3};
        List<List<Integer>> lists = quanPaiLieDemo01.quanPaiLie(arr);
        for (List<Integer> list : lists) {
            System.out.println(list.toString());
        }

    }


}
