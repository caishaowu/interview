package com.bettercsw.prototype.deep;

import java.io.Serializable;

/**
 * @author csw
 * @date 2020/5/19 14:51
 */
public class JinGuBang implements Serializable {

    public float h = 100;
    public float d = 10;

    public void big() {
        this.d *= 2;
        this.h *= 2;
    }

    public void small() {
        this.d /= 2;
        this.h /= 2;
    }
}
