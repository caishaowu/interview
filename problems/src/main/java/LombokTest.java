import pojo.Dog;

/**
 * @author csw
 * @date 2022/3/23 14:53
 */
public class LombokTest {

    public static void main(String[] args) {
        Dog dog1 = new Dog(1, "dog1", "bone", "erha");

        Dog dog2 = new Dog(2, "dog2", "bone", "erha");

        System.out.println(dog1.equals(dog2));
    }
}
