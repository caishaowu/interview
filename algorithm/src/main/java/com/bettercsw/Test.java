package com.bettercsw;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author csw
 * @date 2020/9/9 14:58
 */
public class Test {

    public static void main(String[] args) throws Exception {
        // ExecutorService executorService = Executors.newCachedThreadPool();
        // executorService.submit(new testThread());

        User user1 = new User(2,"xx","male",15);
        User user2 = new User(1,"xx","male",15);
        System.out.println(user1.equals(user2));
    }


}
