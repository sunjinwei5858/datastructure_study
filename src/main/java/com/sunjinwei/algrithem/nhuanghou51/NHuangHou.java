package com.sunjinwei.algrithem.nhuanghou51;

import java.util.ArrayList;
import java.util.List;

/**
 * N皇后问题--力扣51
 * 和全排列差不多 套用框架
 */
public class NHuangHou {

    List<List<Integer>> results = new ArrayList<>();

    private List<List<Integer>> nHuangHou(Integer n) {


        return results;
    }

    // 路径：board 中小于 row 的那些行都已经成功放置了皇后
    // 选择列表：第 row 行的所有列都是放置皇后的选择
    // 结束条件：row 超过 board 的最后一行


    public static void main(String[] args) {
        NHuangHou nHuangHou = new NHuangHou();
        List<List<Integer>> lists = nHuangHou.nHuangHou(4);
        for (List<Integer> list : lists) {
            System.out.println(list.toString());
        }
    }


}
