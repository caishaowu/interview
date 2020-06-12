package com.bettercsw.prototype.deep;

import java.io.*;
import java.util.Date;

/**
 * @author csw
 * @date 2020/5/19 14:53
 */
public class SunWuKong extends Monkey implements Cloneable, Serializable {

    public JinGuBang jinGuBang;

    public SunWuKong() {
        this.birthday = new Date();
        this.jinGuBang = new JinGuBang();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return this.deepClone();
    }

    public Object deepClone() {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(this);

            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);

            SunWuKong copy = (SunWuKong)ois.readObject();
            copy.birthday = new Date();
            return copy;

        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public SunWuKong shallowClone(SunWuKong target) {
        SunWuKong sunWuKong = new SunWuKong();
        sunWuKong.birthday = new Date();
        sunWuKong.height = target.height;
        sunWuKong.weight = target.weight;
        sunWuKong.jinGuBang = target.jinGuBang;
        return sunWuKong;

    }
}
