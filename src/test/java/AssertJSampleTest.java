import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author csw
 * @date 2020/1/10 15:09
 */
public class AssertJSampleTest {
    @Test
    public void testUsingAssertJ() {
        //字符串判断
        String s = "China";
        Assertions.assertThat(s).as("字符串判断：判断首尾及长度").startsWith("C").endsWith("a").hasSize(5);

        //数字判断
        Integer i = 11;
        Assertions.assertThat(i).as("数字判断：比较数字大小").isGreaterThan(0).isLessThan(20);

        //日期判断
        Date date1 = new Date();
        Date date2 = new Date(date1.getTime() + 100);
        Date date3 = new Date(date1.getTime() - 100);
        Assertions.assertThat(date1).as("日期判断：比较日期大小").isBefore(date2).isAfter(date3).isEqualTo(date1);

        //List判断
        List<String> list = Arrays.asList("a", "b", "c", "d");
        Assertions.assertThat(list).as("List 的判断：判断首尾元素及长度").startsWith("a").endsWith("d").hasSize(4);

        //Map判断
        Map<String, Object> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);
        Set<String> set = map.keySet();
        Assertions.assertThat(map).as("Map 的判断：长度及key值").hasSize(3).containsKeys("A", "B", "C");

    }
}
