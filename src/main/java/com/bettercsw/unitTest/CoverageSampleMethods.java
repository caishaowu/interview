package com.bettercsw.unitTest;

/**
 * @author csw
 * @date 2020/1/9 9:58
 */
public class CoverageSampleMethods {
    public Boolean testMethod(int a,int b,int c) {
        boolean result = false;
        if(a == 1 && b ==2 || c == 3) {
            result = true;
        }
        return result;
    }
}

