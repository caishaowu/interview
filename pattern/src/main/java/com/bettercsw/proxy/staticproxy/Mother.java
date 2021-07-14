package com.bettercsw.proxy.staticproxy;

/**
 * @author csw
 * @date 2020/5/19 15:51
 */
public class Mother {
    private Son son;

    //没办法扩展
    public Mother(Son son) {
        this.son = son;
    }

    //帮儿子相亲
    public void findLove() {
        System.out.println("母亲物色对象");
        this.son.findLove();
        System.out.println("双方同意交往，确立关系");
    }
}
