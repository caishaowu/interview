package com.bettercsw.basic;

import java.io.*;

/**
 * @author csw
 * @date 2019/12/9 11:01
 */
public class TestMain {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Test a1 = new Test(123, "abc");
        String objectFile = "test";

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(objectFile));
        oos.writeObject(a1);
        oos.flush();
        System.out.println(new File(objectFile).length());
        oos.writeObject(a1);
        oos.close();
        System.out.println(new File(objectFile).length());


        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(objectFile));
        Test a2 = (Test) ois.readObject();
        Test a3 = (Test) ois.readObject();
        ois.close();
        System.out.println(a2 == a3);
    }

    private static class Test implements Serializable {

        private int x;
        private String y;

        Test(int x, String y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "x = " + x + "  " + "y = " + y;
        }
    }

}
