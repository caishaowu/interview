package com.bettercsw.backingtrack;

/**
 * 假设我们有一个 n 乘以 n 的矩阵 w[n][n]。矩阵存储的都是正整数。棋子起始位置在左上角，终止位置在右下角。我
 * 们将棋子从左上角移动到右下角。每次只能向右或者向下移动一位。从左上角到右下角，会有很多不同的路径可以走。
 * 我们把每条路径经过的数字加起来看作路径的长度。那从左上角移动到右下角的最短路径长度是多少呢？
 *
 * @author csw
 * @date 2020/8/6 10:15
 */
public class minDist {
    public static void main(String[] args) {

    }

    private static int miniDist = Integer.MAX_VALUE;


    private static void getMiniDist(int[][] w, int i, int j, int dist, int n) {
        if (i == n && j == n) {
            if (dist < miniDist) miniDist = dist;
            return;
        }

        if (i < n) {
            getMiniDist(w, i, j + 1, dist + w[i][j], n);
        }
        if (j < n) {
            getMiniDist(w, i + 1, j, dist + w[i][j], n);
        }
    }


}


