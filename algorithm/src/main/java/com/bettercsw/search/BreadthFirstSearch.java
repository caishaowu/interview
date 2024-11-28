package com.bettercsw.search;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author csw
 * @date 2020/7/24 10:08
 */
public class BreadthFirstSearch {

    public static void main(String[] args) {
        Graph graph = new Graph(8);
        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(4, 6);
        graph.addEdge(5, 7);
        graph.addEdge(6, 7);

        graph.bfs(0, 6);
        graph.dfs(0, 6);
    }

    public static class Graph {  //无向图
        private int v; //顶点个数
        private LinkedList<Integer> adj[];  //邻接表

        public Graph(int v) {
            this.v = v;
            adj = new LinkedList[v];

            for (int i = 0; i < v; i++) {
                adj[i] = new LinkedList<>();
            }
        }

        public void addEdge(int s, int t) { //无向图一条边存两次
            adj[s].add(t);
            adj[t].add(s);
        }

        private void bfs(int start, int end) {

            if (start == end) {
                return;
            }
            boolean[] visited = new boolean[v];
            visited[start] = true;  //记录顶点是否已经遍历

            Queue<Integer> queue = new LinkedList<>();   //存放已经遍历过的顶点
            queue.add(start);

            int[] prev = new int[v];   //记录该节点的前驱顶点
            for (int i = 0; i < v; i++) {
                prev[i] = -1;
            }

            while (!queue.isEmpty()) {

                int curr = queue.poll();
                for (int i = 0; i < adj[curr].size(); i++) {
                    int q = adj[curr].get(i);
                    if (!visited[q]) {
                        prev[q] = curr;
                        if (q == end) {   //找到目标顶点，递归输出
                            print(prev, start, end);
                            return;
                        }
                        visited[q] = true;
                        queue.add(q);
                    }
                }
            }
        }

        boolean found = false;  //当我们已经找到目标顶点，就终止递归

        private void dfs(int start, int end) {
            if (start == end) {
                return;
            }
            boolean[] visited = new boolean[v];
            visited[start] = true;  //记录顶点是否已经遍历

            int[] prev = new int[v];   //记录该节点的前驱顶点
            for (int i = 0; i < v; i++) {
                prev[i] = -1;
            }
            recurDfs(start, end, visited, prev);
            print(prev, start, end);
        }

        private void recurDfs(int curr, int end, boolean[] visited, int[] prev) {
            if (found) {
                return;
            }
            visited[curr] = true;
            if (curr == end) {
                found = true;
                return;
            }
            for (int i = 0; i < adj[curr].size(); i++) {
                int p = adj[curr].get(i);
                if (!visited[p]) {
                    prev[p] = curr;
                    recurDfs(p, end, visited, prev);
                }
            }

        }


        private void print(int[] prev, int start, int end) { // 递归打印s->t的路径
            if (prev[end] != -1 && end != start) {
                print(prev, start, prev[end]);
            }
            System.out.print(end + " ");
        }
    }


}
