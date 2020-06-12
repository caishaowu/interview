import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author csw
 * @date 2020/1/10 14:55
 */
public class JUnitSampleTest {
    @Test
    public void testUsingJunitAssertThat() {
        //字符串判断
        String s = "China";
        Assertions.assertTrue(s.startsWith("Ch"));
        Assertions.assertTrue(s.endsWith("a"));
        Assertions.assertEquals(5,s.length());

        //数字判断
        Integer i = 11;
        Assertions.assertTrue(i > 0);
        Assertions.assertTrue( i < 20);

        //日期判断
        Date date1 = new Date();
        Date date2 = new Date(date1.getTime() + 100);
        Date date3 = new Date(date1.getTime() - 100);
        Assertions.assertTrue(date1.before(date2));
        Assertions.assertTrue(date1.after(date3));

        //List判断
        List<String> list = Arrays.asList("a","b","c","d");
        Assertions.assertEquals("a",list.get(0));
        Assertions.assertEquals(4,list.size());
        Assertions.assertEquals("d",list.get(list.size() - 1));

        //Map判断
        Map<String,Object> map = new HashMap<>();
        map.put("A",1);
        map.put("B",2);
        map.put("C",3);
        Set<String> set = map.keySet();
        Assertions.assertEquals(3,map.size());
        Assertions.assertTrue(set.containsAll(Arrays.asList("A","B","C")));
    }
}
