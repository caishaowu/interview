package com.bettercsw.backingtrack;

import java.util.Arrays;

/**
 * @author csw
 * @date 2020/7/30 10:43
 */
public class Sudoku {

    public static void main(String[] args) {
        char[][] ch = new char[9][9];
        for (int i = 0; i < ch.length; i++) {
            Arrays.fill(ch[i], '.');
        }
        ch[0][4] = '3';
        ch[0][6] = '7';
        ch[0][7] = '6';
        ch[1][1] = '1';
        ch[1][3] = '4';
        ch[1][8] = '9';
        ch[2][0] = '9';
        ch[2][2] = '3';
        ch[3][0] = '3';
        ch[3][4] = '6';
        ch[4][1] = '4';
        ch[4][4] = '9';
        ch[4][8] = '1';
        ch[5][5] = '4';
        ch[5][8] = '5';
        ch[6][3] = '1';
        ch[6][8] = '4';
        ch[7][3] = '5';
        ch[7][5] = '3';
        ch[7][6] = '9';
        ch[8][0] = '6';
        ch[8][2] = '7';
        ch[8][7] = '2';
        solveSudoku(ch);
        print(ch);


    }

    public static void solveSudoku(char[][] board) {
        if (board == null || board.length == 0)
            return;
        solve(board, 0, 0);
    }

    private static boolean solve(char[][] board, int row, int column) {
        int i = 9;
        int j = 9;
        //行遍历完了
        if (i == row) {
            return true;
        }
        //列遍历完了，遍历下一行
        if (j == column) {
            return solve(board, row + 1, 0);
        }
        //预先设置好的值，跳过
        if (board[row][column] != '.') {
            return solve(board, row, column + 1);
        }

        for (char ch = '1'; ch <= '9'; ch++) {

            if (isValid(ch, board, row, column)) {
                board[row][column] = ch;
                if (solve(board, row, column)) {
                    return true;
                } else {
                    print(board);
                    board[row][column] = '.';
                }
            }
        }

        return false;
    }


    public static boolean isValid(char ch, char[][] board, int row, int column) {
        for (int i = 0; i < board.length; i++) {
            //检查行
            if (board[i][column] != '.' && board[i][column] == ch) {
                return false;
            }
            // 检查列
            if (board[row][i] != '.' && board[row][i] == ch) {
                return false;
            }
            // 检查 3*3 block
            if (board[3 * (row / 3) + i / 3][3 * (column / 3) + i % 3] != '.' &&
                    board[3 * (row / 3) + i / 3][3 * (column / 3) + i % 3] == ch) {
                return false;
            }

        }


        return true;
    }


    private static void print(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
