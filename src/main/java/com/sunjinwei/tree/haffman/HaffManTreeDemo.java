package com.sunjinwei.tree.haffman;

import java.util.ArrayList;
import java.util.List;

/**
 * 哈夫曼树demo
 * <p>
 * 最优二叉树：带权路径最短，权值越大离根结点越近，权值越小离根结点越远 这样保证了带权路径最短，也就是最优二叉树
 */
public class HaffManTreeDemo {
    public static void main(String[] args) {
        int arr[] = {13, 7, 8, 3, 29, 6, 1};
        HaffManNode root = createHaffManTree(arr);
        preOrder(root);

    }

    /**
     * 前序遍历
     */
    public static void preOrder(HaffManNode root) {
        if (root == null) {
            System.out.println("根结点不能为空");
            return;
        } else {
            root.preOrder();
        }
    }

    /**
     * 进行排序和构造哈夫曼树
     * 1.将数组转化为树为泛型集合 然后进行从小到大排序
     * 2.将前面两个进行相加，然后这三个数构造成一颗树
     * 3.集合移除这两个数，然后将相加的值添加到集合中
     * 4.循环直到集合的size<1为止
     * 5.返回根结点即可，此时哈夫曼树已经创建成功
     */
    public static HaffManNode createHaffManTree(int[] arr) {
        List<HaffManNode> list = new ArrayList<>();
        for (int i : arr) {
            list.add(new HaffManNode(i));
        }

        while (list.size() > 1) {
            // 对结点进行排序 从小到大
            list.sort((o1, o2) -> {
                return o1.getValue() - o2.getValue();
            });

            // 将索引0和索引1的 进行处理
            HaffManNode leftNode = list.get(0);
            HaffManNode rightNode = list.get(1);

            HaffManNode parentNode = new HaffManNode(leftNode.getValue() + rightNode.getValue());
            parentNode.setLeft(leftNode);
            parentNode.setRight(rightNode);

            // 集合移除0和1
            list.remove(leftNode);
            list.remove(rightNode);

            // 将相加的值添加到集合
            list.add(parentNode);
        }

        return list.get(0);

    }
}
