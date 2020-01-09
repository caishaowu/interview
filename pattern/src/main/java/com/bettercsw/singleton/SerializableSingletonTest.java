package com.bettercsw.singleton;

import java.io.*;

/**
 *
 * @author csw
 * @date 2019/12/4 14:58
 */
public class SerializableSingletonTest {

    public static void main(String[] args) {
        EnumSingleton s1 = null;
        EnumSingleton s2 = EnumSingleton.INSTANCE;

        FileOutputStream fos = null;
        File file;
        try {
            fos = new FileOutputStream("test");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(s2);
            oos.flush();
            oos.close();

            FileInputStream fis = new FileInputStream("test");
            ObjectInputStream ois = new ObjectInputStream(fis);
            s1 = (EnumSingleton) ois.readObject();
            ois.close();

            System.out.println(s1 == s2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
