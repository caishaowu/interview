import java.math.BigDecimal;

/**
 * @author csw
 * @date 2022/3/22 15:52
 */
public class BigDecimalTest {

    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal(1);
        BigDecimal bigDecimal1 = new BigDecimal(1);
        System.out.println(bigDecimal.equals(bigDecimal1));

        BigDecimal bigDecimal2 = new BigDecimal(1);
        BigDecimal bigDecimal3 = new BigDecimal(1.0);
        System.out.println(bigDecimal2.equals(bigDecimal3));

        BigDecimal bigDecimal4 = new BigDecimal("1");
        BigDecimal bigDecimal5 = new BigDecimal("1.0");
        System.out.println(bigDecimal4.equals(bigDecimal5));
        System.out.println(bigDecimal4.compareTo(bigDecimal5));

        //禁止使用double构造BigDecimal
        BigDecimal bigDecimal6 = new BigDecimal(0.1);
        BigDecimal bigDecimal7 = new BigDecimal("0.1");
        System.out.println(bigDecimal6.equals(bigDecimal7));
        System.out.println(bigDecimal6.compareTo(bigDecimal7));
    }
}
