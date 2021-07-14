package com.bettercsw;

import java.util.concurrent.Callable;

/**
 * @author csw
 * @date 2021/3/5 15:34
 */
public class testThread implements Callable<Boolean> {
    @Override
    public Boolean call() throws Exception {
        while(true) {
            int page = 1;
            if(page == 1) {
                System.out.println(page);
            }
            page++;
        }

    }
}
