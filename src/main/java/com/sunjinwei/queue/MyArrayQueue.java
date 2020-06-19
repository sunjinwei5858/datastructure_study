package com.sunjinwei.queue;

/**
 * 使用普通数组实现队列
 * 队列：先进先出 first in first out
 */
public class MyArrayQueue {
    // 数组长度
    private int maxSize;
    // 队头
    private int front;
    // 队尾
    private int rear;
    // 数组
    private int arr[];

    public MyArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        front = -1;
        rear = -1;
        arr = new int[maxSize];
    }

    // 判断是否满了
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    // 判断是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    // 添加元素到队列中 将元素添加到队尾rear
    public void addQueue(int a) {
        // 先判断是否满了
        if (isFull()) {
            System.out.println("队列已经满了");
            return;
        }
        // 队尾进行++操作
        rear++;
        arr[rear] = a;
    }

    // 出队列 先进先出 对头front
    public int getQueue() {
        // 先判断队列是否为空
        if (isEmpty()) {
            System.out.println("队列为空");
            throw new RuntimeException("队列为空");
        }
        front++;
        return arr[front];
    }

    // 显示队列的信息
    public void showQueue(){
        if (isEmpty()){
            System.out.println("队列为空");
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(i);
        }
    }


}
