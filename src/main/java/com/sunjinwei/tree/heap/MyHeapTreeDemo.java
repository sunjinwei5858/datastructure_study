package com.sunjinwei.tree.heap;

import java.util.Arrays;

/**
 * https://blog.csdn.net/u010452388/article/details/81283998
 * 第三种写法-----
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
public class MyHeapTreeDemo {

    public static void main(String[] args) {

        int arr[] = {3, 6, 8, 5, 7};

        System.out.println(Arrays.toString(arr));

        heapSort(arr);

        System.out.println(Arrays.toString(arr));

    }

    /**
     * 堆排序
     *
     * @param arr
     */
    public static void heapSort(int[] arr) {
        //1 构造大根堆 首先将待排序的数组构造成一个大根堆， 整个数组的最大值就是堆结构的顶端
        heapInsert(arr);
        int size = arr.length;
        while (size > 1) {
            // 2 将顶端的数与末尾的数交换，此时，末尾的数为最大值，剩余待排序数组个数为n-1
            // 顶端也就是根结点是最大的，与最大索引处的值进行交换
            swap(arr, 0, size - 1);
            // 将剩余的数构造成大根堆 也就是size-1
            size--;
            heapify(arr, 0, size);
        }
    }

    /**
     * 构造大顶堆 通过新插入的数上升
     *
     * @param arr
     */
    public static void heapInsert(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // 当前插入的索引i
            int currentIndex = i;
            // 父结点的索引
            int fatherIndex = (currentIndex - 1) / 2;
            // 如果当前插入的值大于父结点的值 那么就进行交换
            // 然后继续和上面的父结点进行比较 直到不大于父结点 则退出循环
            while (arr[currentIndex] > arr[fatherIndex]) {
                swap(arr, currentIndex, fatherIndex);
                // 将当前索引指向father
                currentIndex = fatherIndex;
                // 重新计算父结点的索引
                fatherIndex = (currentIndex - 1) / 2;
            }
        }
    }

    /**
     * 将剩余的数构造成大根堆（通过顶端的数下降）
     *
     * @param arr
     * @param index
     * @param size
     */
    public static void heapify(int[] arr, int index, int size) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        while (left < size) {
            int largestIndex;
            //判断孩子中较大的值的索引（要确保右孩子在size范围之内）
            if (arr[left] < arr[right] && right < size) {
                largestIndex = right;
            } else {
                largestIndex = left;
            }
            //比较父结点的值与孩子中较大的值，并确定最大值的索引
            if (arr[index] > arr[largestIndex]) {
                largestIndex = index;
            }
            //如果父结点索引是最大值的索引，那已经是大根堆了，则退出循环
            if (index == largestIndex) {
                break;
            }
            //父结点不是最大值，与孩子中较大的值交换
            swap(arr, largestIndex, index);
            //将索引指向孩子中较大的值的索引
            index = largestIndex;
            //重新计算交换之后的孩子的索引
            left = 2 * index + 1;
            right = 2 * index + 2;
        }
    }

    /**
     * 交换元素方法 将index01的值换给index02
     *
     * @param arr
     * @param index01
     * @param index02
     */
    public static void swap(int[] arr, int index01, int index02) {
        int temp = arr[index01];
        arr[index01] = arr[index02];
        arr[index02] = temp;
    }


}
