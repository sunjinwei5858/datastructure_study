package com.sunjinwei.graph;

import java.util.Queue;

/**
 * 使用邻接表实现图
 */
public class Graph {
    // 图的顶点数量
    private int V;

    // 图的边数量
    private int E;

    // 邻接表
    private Queue<Integer>[] adj;

    /**
     * 初始化
     */
    public Graph(int v) {
        // 初始化顶点数量
        this.V = v;
        // 初始化边的数量
        this.E = 0;
        // 初始化邻接表
        //this.adj = new Queue[];

        for (int i = 0; i < adj.length; i++) {

        }
    }


}
