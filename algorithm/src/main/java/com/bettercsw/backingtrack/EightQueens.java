package com.bettercsw.backingtrack;

/**
 * 八皇后问题：往 8 * 8的棋盘中放入8个棋子，要求每个棋子所在行，列，对角线都不存在别的棋子
 * 找出所有满足这种要求的放法
 *
 * @author csw
 * @date 2020/7/28 16:45
 */
public class EightQueens {
    static int[] result = new int[8];  //记录满足要求的方法

    public static void main(String[] args) {
        calEightQueens(0);
    }

    /**
     * @param row 行
     */
    public static void calEightQueens(int row) {
        if (row == 8) {
            printQueens(result);
            return;
        }

        for (int column = 0; column < 8; column++) {
            result[row] = column;
            if (isSatisfy(row, column)) {
                calEightQueens(row + 1);
            }
        }

    }

    /**
     * 判断 row 行 column列是否满足要求放法
     *
     * @param row    行
     * @param column 列
     * @return
     */
    private static boolean isSatisfy(int row, int column) {
        int leftup = column - 1;
        int rightup = column + 1;
        for (int i = row - 1; i >= 0; i--) {
            if (result[i] == column) {  //第 i 行的第 column列有棋子吗？
                return false;
            }
            if (leftup >= 0 && result[i] == leftup) {  //第i行左上对角线上有棋子吗？
                return false;
            }
            if (rightup < 8 && result[i] == rightup) {
                return false;
            }
            --leftup;
            ++rightup;
        }
        return true;
    }

    /**
     * 打印出一个二维矩阵
     *
     * @param result
     */
    private static void printQueens(int[] result) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (result[i] == j) {
                    System.out.print("Q ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

}
