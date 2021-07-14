package com.bettercsw.backingtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        ch[0][7] = '6';
        ch[0][4] = '7';
        ch[0][8] = '2';
        ch[1][2] = '8';
        ch[1][5] = '2';
        ch[1][8] = '9';
        ch[2][0] = '3';
        ch[2][3] = '9';
        ch[2][6] = '7';
        ch[2][8] = '5';
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
