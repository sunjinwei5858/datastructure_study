package com.sunjinwei.algrithem.array;

import java.util.ArrayList;

/**
 * 求两个数组的交集： 给定两个数组，编写一个函数来计算它们的交集。
 * 力扣350
 */
public class Demo350 {


    public static void main(String[] args) {
        int arr1[] = new int[]{1, 2, 2, 1};
        int arr2[] = new int[]{2, 2};
        int[] ints = method01(arr1, arr2);
        //System.out.println(Arrays.toString(ints));

        ArrayList<Integer> list01 = new ArrayList<Integer>();
        ArrayList<Integer> list02 = new ArrayList<Integer>();
        list01.add(1);
        list01.add(2);
        list01.add(209);

        list02.add(1);
        list02.add(3);
        list02.add(4);
        list02.add(2);

        System.out.println(list02.size());

        boolean b = list02.retainAll(list01);

        System.out.println(list02.size());


    }

    /**
     * 方法实现1
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] method01(int nums1[], int nums2[]) {











        return new int[3];


    }


}
