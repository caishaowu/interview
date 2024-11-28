package com.bettercsw.backingtrack;

/**
 * @author csw
 * @date 2021/8/31 16:49
 */
public class WordSearch {
    public static void main(String[] args) {
        WordSearch wordSearch = new WordSearch();
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(wordSearch.exist(board, "SEE"));
    }

    public boolean exist(char[][] board, String word) {

        int w = board[0].length;
        int h = board.length;
        boolean men[][] = new boolean[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                boolean flag = check(board, men, i, j, word, 0);
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean check(char[][] board, boolean[][] men, int x, int y, String word, int idx) {
        if (word.charAt(idx) != board[x][y]) {
            return false;
        } else if (word.length() - 1 == idx) {
            return true;
        }
        men[x][y] = true;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean result = false;
        for (int[] direction : directions) {
            int newx = x + direction[0];
            int newy = y + direction[1];
            if (newx >= 0 && newx < board.length) {
                if (newy >= 0 && newy < board[0].length) {
                    if (!men[newx][newy]) {
                        boolean flag = check(board, men, newx, newy, word, idx + 1);
                        if (flag) {
                            result = true;
                            break;
                        }
                    }

                }
            }
        }
        men[x][y] = false;
        return result;

    }

}
