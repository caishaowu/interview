package com.chinaunicom;

import org.junit.Test;

import java.security.MessageDigest;
import java.util.function.Function;

/**
 * @author csw
 * @date
 */
public class Homework {
    /**
     * 计算去重后的个数
     * @param arr
     * @return
     */
    public static int countUnique(int arr[]){

        int rows = Integer.MAX_VALUE >> 3;
        byte[] bytes = new byte[rows + 1];

        int count = 0;
        for(int i: arr){
            //计算对应行数
            int row = i >> 3;
            //计算在字节数组中对应的列数
            int col = i % 8;
           if((bytes[row] & (1<<col)) == 0){
               count++;
               bytes[row] = (byte) (bytes[row] | (1 << col));
           }
        }
        return count;
    }

    @Test
    public void test(){
        int[] arr = {Integer.MAX_VALUE,0,127,0,128,1,127,Integer.MAX_VALUE};
        System.out.println(Homework.countUnique(arr));
    }
    @Test
    public void count(){
        double sum = 0;
        for(int i = 0; i<= 6;i++){
            sum += 1666.67 * (6 - i) * 0.0004 * 30;
        }
        System.out.println(sum);
    }

    @Test
    public void MD5Encode(){
        String str = "4cf2dec018b36ddbc906f8fb28f5338f";
        try{
            byte[] bytesOfMessage = str.getBytes("UTF-8");
            for (byte b : bytesOfMessage) {
                System.out.print(b);
            }
            System.out.println();
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] theDigest = md.digest(bytesOfMessage);
            for (byte b : theDigest) {
                System.out.print(b);
            }

        }catch (Exception e){

        }

    }

    @Test
    public void VarIncre() {
        int i = 1;
        i = i++;
        int j = i++;
        int k = i + ++i * i++;
        System.out.println("i=" + i);  //4
        System.out.println("j=" + j);  //1
        System.out.println("k=" + k);  //11
    }

}
