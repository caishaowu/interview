package com.bettercsw.basic;

/**
 * @author csw
 * @date
 */
public class Variables {
    static int s;
    int i;
    int j;

    {
        int i = 1;
        i++;
        j++;
        s++;
    }

    public void test(int j) {
        j++;

        i++;
        s++;
    }

    public static void main(String[] args) {
        Variables var1 = new Variables();
        Variables var2 = new Variables();
        var1.test(10);
        var1.test(20);
        var2.test(30);
        System.out.println(var1.i + "," + var1.j + "," + Variables.s);
        System.out.println(var2.i + "," + var2.j + "," + Variables.s);

        int m = -4;
        System.out.println(m << 1);
        System.out.println(m << 33);
        System.out.println(m >> 1);
        System.out.println(m >> 32);
        System.out.println(m >>> 32);

    }
}
