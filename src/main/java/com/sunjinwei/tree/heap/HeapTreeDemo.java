package com.sunjinwei.tree.heap;

import java.util.Arrays;

/**
 * 第一种写法----
 * 堆排序: 是完全二叉树
 * 堆特点：
 * 大顶堆满足条件 arr(i)>arr(2*i+1) && arr(i)>arr(2*i+2)
 * 小顶堆满足条件 arr(i)<arr(2*i+1) && arr(i)<arr(2*i+2)
 * 堆排序基本思想：
 * 1.首先将待排序的数组构造成一个大根堆，此时，整个数组的最大值就是堆结构的顶端
 * 2.将顶端的数与末尾的数交换，此时，末尾的数为最大值，剩余待排序数组个数为n-1
 * 3.将剩余的n-1个数再构造成大根堆，再将顶端数与n-1位置的数交换，如此反复执行，便能得到有序数组
 * 将无序数组构造成一个大根堆（升序用大根堆，降序就用小根堆）
 */
public class HeapTreeDemo {
    public static void main(String[] args) {
        int arr[] = {4, 6, 8, 5, 9};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    /**
     * 编写堆排序代码
     */
    public static void heapSort(int[] arr) {

        System.out.println("堆排序");

        /**
         * 分布完成演示
         */
       /*
        adjustHeap(arr, 1, arr.length);
        System.out.println("第一次调整：" + Arrays.toString(arr));
        adjustHeap(arr,0,arr.length);
        System.out.println("第二次调整：" + Arrays.toString(arr)); // 9 6 8 5 4
        */


        /**
         * 1.一次全部完成, 将无序调整成大顶堆
         */
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }

        /**
         * 2 进行排序
         *  将堆顶元素与最末元素进行交换 将最大元素沉到最底;
         *  重新调整结构 使其满足堆结构 然后继续交换
         */
        int temp = 0;
        for (int j = arr.length - 1; j > 0; j--) {
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;

            // 重新调整
            adjustHeap(arr, 0, j);
        }

    }

    /**
     * 将一个数组构造成一个大顶堆
     * 完成以i对应的非叶子结点的树调整成大顶堆
     *
     * @param arr    待调整的数组
     * @param i      非叶子结点在数组中的索引
     * @param length 表示对多少个元素继续调整，length在逐渐减少
     */
    public static void adjustHeap(int[] arr, int i, int length) {
        // 结点i的值作为临时变量进行存储
        int temp = arr[i];
        // 2*i+1 为i结点的左子结点
        for (int k = 2 * i + 1; k < length; k = 2 * k + 1) {
            // 1找出右子结点 还是左子结点更大 哪个大k就指向谁
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                // 如果左子结点小于于右子结点 那么k++ 指向右子结点
                k++;
            }
            // 2左子结点或者右子结点与i结点进行比较
            if (arr[k] > temp) {
                // 如果子结点比i结点的值更大，那么进行交换
                arr[i] = arr[k];
                // !!! i指向k 继续循环 否则break
                i = k;
            } else {
                break;
            }
        }
        // !!! for循环结束后 我们已经将以i为父结点的树的最大值，放在了最顶 局部
        arr[i] = temp;
    }

}
