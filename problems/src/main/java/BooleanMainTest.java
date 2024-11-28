import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import pojo.BooleanTest3;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 * @author csw
 * @date 2022/3/21 15:50
 */
public class BooleanMainTest {

    public static void main(String[] args) throws IOException {
        BooleanTest3 test3 = new BooleanTest3();
        test3.setSuccess(true);

        //使用 fastJson 序列化
        System.out.println("Serializable Result With fastjson :" + JSON.toJSONString(test3));

        //使用 gson 序列化
        Gson gson = new Gson();
        System.out.println("Serializable Result With gson :" + gson.toJson(test3));

        //使用 fastJson 序列化， gson 反序列化
        System.out.println(gson.fromJson(JSON.toJSONString(test3), BooleanTest3.class));
    }
}
