package com.sunjinwei.algrithem.array;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 删除排序数组中的重复项
 * <p>
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Demo26 {

    /**
     * 双指针法： 一个快指针，一个慢指针
     *
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        /**
         * j属于慢指针， i属于快指针
         */
        int j = 0;

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] != nums[j]) {
                j++;
                nums[j] = nums[i];
            }
        }

        System.out.println(Arrays.toString(nums));
        return j + 1;
    }

    public static int removeDuplicates02(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        HashMap<Integer, Integer> integerIntegerHashMap = new HashMap<>(nums.length);

        for (int i = 0; i < nums.length; i++) {
            if (!integerIntegerHashMap.containsKey(nums[i])) {
                integerIntegerHashMap.put(nums[i], i);
            }
        }
        return integerIntegerHashMap.size();
    }

    public static void main(String[] args) {
        int removeDuplicates = removeDuplicates02(new int[]{1, 1, 2});
        System.out.println(removeDuplicates);
    }


}
