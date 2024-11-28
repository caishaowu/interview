import java.util.HashMap;
import java.util.Map;

/**
 * @author csw
 * @date 2022/3/22 16:14
 */
public class ConditionTest {

    public static void main(String[] args) {
        Map<String, Boolean> map = new HashMap<>();

        boolean b = (map != null ? map.get("test") : false);

        System.out.println(b);
    }
}
