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

    public static void main(String[] args) {
        NHuangHou nHuangHou = new NHuangHou();
        List<List<Integer>> lists = nHuangHou.nHuangHou(4);
        for (List<Integer> list : lists) {
            System.out.println(list.toString());
        }
    }


}
