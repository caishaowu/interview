package com.bettercsw.prototype.shallow;

/**
 * @author csw
 * @date 2020/5/19 14:26
 */
public class Client {

    private Prototype prototype;

    public Client(Prototype prototype) {
        this.prototype = prototype;
    }

    public Prototype startClone() {
        return prototype.clone();
    }
}
