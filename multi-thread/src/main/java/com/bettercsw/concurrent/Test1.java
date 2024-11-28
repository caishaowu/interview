package com.bettercsw.concurrent;

import com.google.common.io.Files;

/**
 * @author csw
 * @date 2021/11/12 10:05
 */
public class Test1 {

    public static void main(String[] args) throws Exception {
        System.out.println(Files.getFileExtension("1.php%00.jpg"));

    }


}
