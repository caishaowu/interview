package com.bettercsw;


/**
 * @author csw
 * @date 2020/9/9 14:58
 */
public class Test {

    public static void main(String[] args) throws Exception {
        // ExecutorService executorService = Executors.newCachedThreadPool();
        // executorService.submit(new testThread());

        Test test = new Test();
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        test.rotate(matrix);
    }

    public void rotate(int[][] matrix) {
        int h = matrix.length;
        int w = matrix[0].length;
        int temp = h - 1;
        int[][] result = new int[h][w];
        for (int x = 0; x < h; x++) {
            for (int y = 0; y < w; y++) {
                result[y][x] = matrix[temp][y];
            }
            temp--;
        }


        for (int x = 0; x < h; x++) {
            for (int y = 0; y < w; y++) {
                matrix[x][y] = result[x][y];
            }
        }
        System.out.println(matrix);
    }

}
