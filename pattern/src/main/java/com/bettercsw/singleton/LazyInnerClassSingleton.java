package com.bettercsw.singleton;

/**
 * @author csw
 * @date 2019/11/29 15:24
 */
public class LazyInnerClassSingleton {

    private LazyInnerClassSingleton() {
        if (InnerClass.LAZY != null) {
            throw new RuntimeException("不允许创建多个实例");
        }
    }

    private static class InnerClass {
        private static final LazyInnerClassSingleton LAZY = new LazyInnerClassSingleton();
    }

    public static LazyInnerClassSingleton getInstance() {
        return InnerClass.LAZY;
    }

}
