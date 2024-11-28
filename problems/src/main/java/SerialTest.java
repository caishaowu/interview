import java.io.*;

/**
 * @author csw
 * @date 2022/3/22 10:41
 */
public class SerialTest {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Test a1 = new Test(123, "abc");
        String objectFile = "test";

        // 序列化
        // ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(objectFile));
        // oos.writeObject(a1);
        // oos.close();

        //反序列化
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(objectFile));
        Test a2 = (Test) ois.readObject();
        ois.close();
    }

    private static class Test implements Serializable {

        // private static final long serialVersionUID = 90052535171358087L;
        private int x;
        private String y;
        private String z;


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
