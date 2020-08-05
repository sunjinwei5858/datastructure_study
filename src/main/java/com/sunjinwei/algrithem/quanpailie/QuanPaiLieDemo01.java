package com.sunjinwei.algrithem.quanpailie;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 全排列--力扣46
 * 回溯算法框架
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class QuanPaiLieDemo01 {

    List<List<Integer>> results = new ArrayList<>();

    private List<List<Integer>> quanPaiLie(int[] nums) {
        LinkedList<Integer> integers = new LinkedList<>();
        backtrack(nums, integers);
        return results;
    }

    private void backtrack(int[] nums, LinkedList<Integer> integers) {
        for (int i = 0; i < nums.length; i++) {
            if (integers.size() == nums.length) {
                // new LinkedList<>(integers) 其实就是addAll
                results.add(new LinkedList<>(integers));
                return;
            }
            // 如果集合包含 那么跳过
            if (integers.contains(nums[i])) {
                continue;
            }
            // 进行选择
            integers.add(nums[i]);
            // 进行递归
            backtrack(nums, integers);
            // 进行回溯 撤销
            integers.removeLast();
        }

    }

    public static void main(String[] args) {
        QuanPaiLieDemo01 quanPaiLieDemo01 = new QuanPaiLieDemo01();
        int[] arr = {1, 2, 3};
        List<List<Integer>> lists = quanPaiLieDemo01.quanPaiLie(arr);
        for (List<Integer> list : lists) {
            System.out.println(list.toString());
        }

    }


}
