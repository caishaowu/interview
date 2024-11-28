

import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;

/**
 * @author csw
 * @date 2022/3/22 16:36
 */
public class ForeachTest {

    public static void main(String[] args) {
        List<String> userNames = new ArrayList<>();
        userNames.add("admin");
        userNames.add("guest");
        userNames.add("root");

        System.out.println(" 使用 foreach 遍历 List");
        for (String userName : userNames) {
            if (userName.equals("admin")) {
                userNames.remove(userName);
            }

        }

        // Iterator iterator = userNames.iterator();
        // do
        // {
        //     if(!iterator.hasNext())
        //         break;
        //     String userName = (String)iterator.next();    //ConcurrentModificationException
        //     if(userName.equals("admin"))
        //         userNames.remove(userName);
        //         // iterator.remove();
        // } while(true);


        // System.out.println(" 使用 for 循环遍历 List");
        // for (int i = 0; i < userNames.size(); i++) {
        //     if(userNames.get(i).equals("guest")) {
        //         userNames.remove(i);
        //     }
        // }
        // System.out.println(userNames);
    }
}
