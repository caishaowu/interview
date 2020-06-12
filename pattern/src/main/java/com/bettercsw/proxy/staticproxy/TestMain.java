package com.bettercsw.proxy.staticproxy;

/**
 * @author csw
 * @date 2020/5/19 15:54
 */
public class TestMain {
    public static void main(String[] args) {
        //只能帮儿子找对象，不能帮表妹、不能帮陌生人
        Mother mother = new Mother(new Son());
        mother.findLove();
    }
}
